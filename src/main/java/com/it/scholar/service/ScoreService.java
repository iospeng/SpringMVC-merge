package com.it.scholar.service;

import com.it.scholar.domain.Score;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional  // 表示该类中的所有方法均使用事务
public interface ScoreService {
    public Score findByID(Integer id);
    public List<Score> selectAll();
}
