package com.it.scholar.service;

import com.it.scholar.domain.Score;

import java.util.List;

public interface ScoreService {
    public Score findByID(Integer id);
    public List<Score> selectAll();
}
