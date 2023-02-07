package com.example.spring_crud_demo1.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IssueEntity {
    private int id;
    private String summary;
    private String description;
}
