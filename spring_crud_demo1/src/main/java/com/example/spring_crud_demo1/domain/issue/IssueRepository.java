package com.example.spring_crud_demo1.domain.issue;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IssueRepository {

    @Select("SELECT * FROM issues")
    List<IssueEntity> findAll();

}
