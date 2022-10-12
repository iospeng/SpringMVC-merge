package com.it.scholar.dao;

import com.it.scholar.domain.Score;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ScoreDao {

    @Select("select * from score where id = #{id}")
    Score findByID(Integer id);

    @Select("select * from score")
    List<Score> selectAll();

    @Insert("INSERT INTO `score` VALUES(#{id},#{user_id},#{name},#{languageScore})")
    Boolean insertScore(Score score);

    // @Param 若dao层接口有多个参数，需要使用该注解区分sql语句中的参数与接口形参的对应关系,否则接收不到前端传的参数
    @Update("UPDATE `score`SET languageScore = #{languageScore} WHERE ID = #{id}")
    Boolean upDateScore(@Param("id") Integer id, @Param("languageScore") double languageScore);

    @Delete("DELETE FROM `score` WHERE id = #{id}")
    Boolean deleteScore(Integer id);
}
