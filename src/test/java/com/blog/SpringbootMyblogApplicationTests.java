package com.blog;

import com.github.kevinsawicki.http.HttpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMyblogApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void testApi(){
//		String url = "http://localhost:8080/user/get";
//
//		String res = HttpRequest.get(url).body();
//		System.out.println("response:"+res);
//	}


	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Test
	public void testredis(){

		System.out.println(stringRedisTemplate.opsForValue().get("9184e7c996724b8f93edc9804e470bea").toString());
	}

}
