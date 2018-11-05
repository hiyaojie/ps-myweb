package com.blog.support;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by hulixiong on 2016/10/31.
 * 处理请求报文和返回报文，请求报文格式为｛
 “data”:{}  //填写具体请求的json参数，get和delete方法body内容为空，参数写在url中。
 ｝ 通过过滤器提取data内容

 成功返回报文格式为｛
 “code”:0”,
 “msg”:””,
 “data”:{}
 ｝
 通过过滤器添加code，msg，并将具体业务数据插入data字段中
 */
@Slf4j
public class DatagramFilter extends OncePerRequestFilter {


    private Logger logger = LoggerFactory.getLogger(DatagramFilter.class);

//    JsonMapper mapper = new JsonMapper();

    static String successResponse = "{\"code\":0,\"msg\":\"success!\" }";
    static String successResponseWithData = "{\"code\":0,\"msg\":\"success!\",\"data\":%s }";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path = (request).getRequestURI();
        processUsername(request);
        if (!path.startsWith("/api") ) {
            filterChain.doFilter(request, response);
        } else {

            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");


            //filter处理请求报文
            DatagramRequestWrapper requestWrapper = new DatagramRequestWrapper(request);
            requestWrapper.processRequestDatagram();
            //filter处理返回报文
            DatagramResponseWrapper responseWrapper = new DatagramResponseWrapper(response);

            filterChain.doFilter(requestWrapper, responseWrapper);

            String responseDatagram = responseWrapper.processResponseDatagram();
            logger.info("response body: "+responseDatagram);
            responseWrapper.getWriter().print(responseDatagram);
        }
    }


    StringRedisTemplate stringRedisTemplate;

    private void processUsername(HttpServletRequest request) {

        String userInfo = request.getHeader("Username");
        String areaCode = request.getHeader("AreaCode");
        String type = request.getHeader("Type");
        String token = request.getHeader("token");
        System.out.println(token);
//        String user = stringRedisTemplate.opsForValue().get(token);
//        System.out.println(user);
//        System.out.println(user);
//        UserInfoUtil.setUsername(userInfo);
//        UserInfoUtil.setAreaCode(areaCode);
//        UserInfoUtil.setType(type);

    }

    class DatagramResponseWrapper extends HttpServletResponseWrapper {
        private ByteArrayOutputStream baOut;
        private HttpServletResponse response;
        private ServletOutputStream sos;



        public DatagramResponseWrapper(HttpServletResponse response) throws IOException {
            super(response);
            this.response = response;
        }
        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (sos == null) {
                baOut = new ByteArrayOutputStream();
                sos = new ServletOutputStream() {
                    @Override
                    public boolean isReady() {
                        return false;
                    }

                    @Override
                    public void setWriteListener(WriteListener listener) {

                    }

                    @Override
                    public void write(int b) throws IOException {
                        baOut.write(b);
                    }
                };
            }
            return sos;
        }

        String processResponseDatagram() throws UnsupportedEncodingException {
            //处理Controller返回为空的情况
            if (baOut == null ) {
                return successResponse;
            }
            String originalString = new String(baOut.toByteArray(), "UTF-8");
            //处理Controller返回contenttype不是 json格式的情况
            if(!"application/json;charset=UTF-8".equals(this.response.getContentType())) {
                return originalString;
            }
            //处理Controller返回异常的情况
            if (originalString.contains("\"code\"") &&
                    originalString.contains("\"msg\"") ) {
                return originalString;
            }
            String responseBody = String.format(successResponseWithData, originalString);
            return responseBody;
        }

    }



    class DatagramRequestWrapper extends HttpServletRequestWrapper {
        private byte[] body;

        public DatagramRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            body =  IOUtils.toByteArray(request.getInputStream());
        }

        /**
         * 处理请求报文,去掉包裹具体报文的data字段
         * @throws UnsupportedEncodingException
         */
        void processRequestDatagram() throws UnsupportedEncodingException {
            if (body.length == 0 ) {
                return;
            }
            String originalString = new String(body, "UTF-8");
            logger.info("request body: "+originalString);
//            RequestBodyDataDto requestBodyDataDto = mapper.fromJson(originalString, RequestBodyDataDto.class);
//            if (requestBodyDataDto.getData() == null) {
//                throw new RuntimeException("请求参数错误，缺少data字段");
//            }
//            String content = mapper.toJson(requestBodyDataDto.getData());
            body = originalString.getBytes("UTF-8");
        }


        @Override
        public ServletInputStream getInputStream() throws IOException {
            final ByteArrayInputStream bais = new ByteArrayInputStream(body);
            return new ServletInputStream() {

                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener readListener) {

                }

                @Override
                public int read() throws IOException {
                    return bais.read();
                }
            };
        }

    }





}
