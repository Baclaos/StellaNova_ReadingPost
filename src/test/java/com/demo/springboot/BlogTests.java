package com.demo.springboot;

import com.demo.springboot.Model.*;
import com.demo.springboot.Repositories.*;
import com.demo.springboot.ServiceInterfaces.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.text.*;
import java.util.*;

@SpringBootTest
class BlogTests {

	@Autowired
	IBlogService blogService;

	@Autowired
	IBlogRepo blogRepo;

	@Test
	void GetAllBlogItems() {
		List<Blog> blogList = new ArrayList<>();
		blogList = blogRepo.getAllByBlogIDAfter(0);

		Assertions.assertNotEquals(0, blogList.stream().count());
	}

	@Test
	void GetBlogItem() {

		Blog actualBlog = blogRepo.getBlogByBlogID(1);

		Blog expectedBlog = new Blog(1,"Test", "2022.01.10","TestDescription");
		Assertions.assertEquals(expectedBlog, actualBlog);
	}
}
