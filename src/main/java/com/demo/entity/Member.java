package com.demo.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "member")
public class Member {

    private String uid;
    private String name;
}
