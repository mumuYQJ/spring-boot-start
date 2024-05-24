package com.csdj.springbootredis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringBootRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	void contextLoads() {
	}

	/**
	 * list
	 */
	@Test
	void list() {
		String keyName = "a";
		stringRedisTemplate.opsForList().leftPush(keyName,"1");
		stringRedisTemplate.opsForList().leftPush(keyName,"2");
		stringRedisTemplate.opsForList().leftPush(keyName,"3");
//		List<String> stringList = stringRedisTemplate.opsForList().range(keyName, 0, -1);
//		for (String s : stringList) {
//			System.out.println(s);
//		}
		String s = stringRedisTemplate.opsForList().rightPop(keyName);
		Assertions.assertEquals("1",s);
	}

	@Test
	void set() {
		String keyName = "b";
		stringRedisTemplate.opsForSet().add(keyName,"1","2","3","4");
		Boolean flag = stringRedisTemplate.opsForSet().isMember(keyName, "5");
		Assertions.assertFalse(flag);
		Set<String> members = stringRedisTemplate.opsForSet().members(keyName);
		members.forEach(System.out::println);
	}

	@Test
	void zset() {
		String keyName = "c";
		stringRedisTemplate.opsForZSet().add(keyName,"1",20f);
		stringRedisTemplate.opsForZSet().add(keyName,"21",30f);
		stringRedisTemplate.opsForZSet().add(keyName,"42",40f);
		stringRedisTemplate.opsForZSet().add(keyName,"1",10f);
		Long size = stringRedisTemplate.opsForZSet().size(keyName);
		Assertions.assertEquals(3,size);
	}

	@Test
	void hash() {
		String keyName = "d";
		stringRedisTemplate.opsForHash().put(keyName,"a","1");
		stringRedisTemplate.opsForHash().put(keyName,"b","11");
		stringRedisTemplate.opsForHash().put(keyName,"v","3");
		stringRedisTemplate.opsForHash().put(keyName,"c","432");
		Object object = stringRedisTemplate.opsForHash().get(keyName, "a");
		if (object instanceof String) {
			System.out.println("这是string");
		}
	}
}
