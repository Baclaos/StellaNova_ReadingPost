package com.demo.springboot.Controller;

import com.demo.springboot.Model.*;
import com.demo.springboot.Repositories.*;
import com.demo.springboot.ServiceInterfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/reading")
public class BlogController {

        public List<Blog> blogList = new ArrayList<>();

        @Autowired
         IBlogRepo si;

    @GetMapping("/get")
    public ResponseEntity<List<Blog>> GetBlogItem()
    {

        blogList = si.getAllByBlogIDAfter(0);

        if (blogList != null)
        {

            return ResponseEntity.ok(blogList);
        }
        return ResponseEntity.notFound().build();
    }
}
