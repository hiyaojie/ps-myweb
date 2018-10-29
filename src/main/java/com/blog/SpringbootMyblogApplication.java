package com.blog;


import com.blog.support.DatagramFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@MapperScan("com.blog.mapper")
//@ComponentScan(basePackages = {"com.blog.*"})
public class SpringbootMyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMyblogApplication.class, args);
	}

	@Bean
	/**
	 * ����ͳһ����filter
	 */
	public FilterRegistrationBean greetingFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("datagramFilter");
		DatagramFilter filter = new DatagramFilter();
		registrationBean.setFilter(filter);
		registrationBean.setOrder(1);
		List<String> servletList = new ArrayList<String>();
		servletList.add("dispatcherServlet");
		registrationBean.setServletNames(servletList);
		return registrationBean;
	}

	@Bean
	public Converter<String, Date> addNewConvert() {
		return new Converter<String, Date>() {
			@Override
			public Date convert(String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = null;
				if (!StringUtils.isEmpty(source)){
					try {
						date = sdf.parse( source);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return date;
			}
		};
	}

}
