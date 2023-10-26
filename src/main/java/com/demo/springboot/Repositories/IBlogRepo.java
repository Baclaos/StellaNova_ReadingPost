package com.demo.springboot.Repositories;

import com.demo.springboot.Model.*;
import org.springframework.data.jpa.repository.*;

import java.awt.print.*;
import java.util.*;

public interface IBlogRepo extends JpaRepository<Blog, String> {

    List<Blog> getAllByBlogIDAfter(int id);
    Blog getBlogByBlogID(int id);
}
