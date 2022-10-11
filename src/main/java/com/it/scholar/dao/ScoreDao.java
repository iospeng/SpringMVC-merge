package com.it.scholar.dao;

import com.it.scholar.domain.Score;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ScoreDao {

    @Select("select * from score where id = #{id}")
    Score findByID(Integer id);
    @Select("select * from score")
    List<Score> selectAll();
}
