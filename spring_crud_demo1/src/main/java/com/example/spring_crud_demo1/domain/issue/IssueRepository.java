package com.example.spring_crud_demo1.domain.issue;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IssueRepository {

    @Select("SELECT * FROM issues")
    List<IssueEntity> findAll();

    @Insert("INSERT INTO issues(summary, description) VALUES(#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("SELECT * FROM issues WHERE id = #{id}")
    IssueEntity findById(int id);

    @Delete("DELETE FROM issues WHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE issues SET summary = #{summary}, description = #{description} WHERE id = #{id}")
    void update(String summary, String description, int id);

}
