package com.finalProject.blogDataService.controller;


import com.finalProject.blogDataService.model.Blog;
import com.finalProject.blogDataService.service.impl.BlogService;
import com.finalProject.blogDataService.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlogController {

   @Autowired
   private BlogService blogService;

   @GetMapping("/blog/user/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Blog getBlog(@PathVariable Integer id){
     return blogService.getBlog(id);

   }

}
