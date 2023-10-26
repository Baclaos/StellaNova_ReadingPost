package com.demo.springboot.Service;


import com.demo.springboot.Model.*;
import com.demo.springboot.Repositories.*;
import com.demo.springboot.ServiceInterfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.text.*;
import java.util.*;

@Repository
public class BlogService implements IBlogService
{
    @Autowired
    IBlogRepo blogRepo;
}

