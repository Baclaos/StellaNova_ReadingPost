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
	void PostBlogItem() {
		Collection<Role> roles = new ArrayList<>();
		Role role = new Role(Long.valueOf(1),"ROLE_USER");
		roles.add(role);
		Account account = new Account(Long.valueOf(5),"jrut3", "$2a$10$1qDGw36gZnGTlfAVXa9EFO2GEu5vk.FC5Aq1nyzBZAtQXmIRqSOoW", "test", roles);

		int blogID = 0;
		blogService.AddBlog(account.getUserID(), account.getUserName(), "Today im writing this Blog.");
		List<Blog> blogList = blogRepo.getAllByBlogIDAfter(0);
		for (Blog blog: blogList)
		{
			blogID = blog.getBlogID();
		}

		Blog actualBlog = blogRepo.getBlogByBlogID(blogID);

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());

		Blog expectedBlog = new Blog(actualBlog.getBlogID(),"jrut3", timeStamp,"Today im writing this Blog." );
		Assertions.assertEquals(expectedBlog, actualBlog);

		blogRepo.delete(actualBlog);

	}

	@Test
	void GetBlogItem() {

		Blog actualBlog = blogRepo.getBlogByBlogID(1);

		Blog expectedBlog = new Blog(1,"Test", "2022.01.10","TestDescription");
		Assertions.assertEquals(expectedBlog, actualBlog);
	}
}
