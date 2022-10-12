package com.it.scholar.service;

import com.it.scholar.dao.ScoreDao;
import com.it.scholar.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreDao scoreDao;

    @Override
    public Score findByID(Integer id) {
        return scoreDao.findByID(id);
    }

    @Override
    public List<Score> selectAll() {
        return scoreDao.selectAll();
    }

    @Override
    public Boolean insertScore(Score score) {
        return scoreDao.insertScore(score);
    }

    @Override
    public Boolean upDateScore(Integer id, double languageScore) {
        return scoreDao.upDateScore(id, languageScore);
    }

    @Override
    public Boolean deleteScore(Integer id) {
        return scoreDao.deleteScore(id);
    }
}
