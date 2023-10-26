package com.demo.springboot.Model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Blog
{
    @Id
    private int blogID;

    private String author;
    private String time;
    private String description;


    public int getBlogID() {
        return blogID;
    }
    public String getAuthor() {
        return author;
    }
    public String getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }
}
