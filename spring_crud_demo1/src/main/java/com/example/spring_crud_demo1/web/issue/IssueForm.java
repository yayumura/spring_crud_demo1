package com.example.spring_crud_demo1.web.issue;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IssueForm {

    @NotNull
    @Size(max=256)
    private String summary;

    @NotNull
    @Size(max=256)
    private String description;
}
