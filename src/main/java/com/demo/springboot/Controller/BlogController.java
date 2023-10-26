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
@RequestMapping("/blog")
public class BlogController {

        public List<Blog> bookList = new ArrayList<>();

        @Autowired
         IBlogRepo si;

    @GetMapping("/get")
    public ResponseEntity<List<Blog>> GetBlogItem()
    {
        bookList = si.getAllByBlogIDAfter(0);

        if (bookList != null)
        {
            return ResponseEntity.ok(bookList);
        }
        return ResponseEntity.notFound().build();
    }
}
