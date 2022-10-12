package com.it.scholar.service;

import com.it.scholar.domain.Score;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional  // 表示该类中的所有方法均使用事务
public interface ScoreService {
    /**
     * 按id查找分数
     * @param id
     * @return
     */
    public Score findByID(Integer id);

    /**
     * 查找全部分数
     * @return
     */
    public List<Score> selectAll();

    /**
     * 新增分数
     * @param score
     * @return
     */
    public Boolean insertScore(Score score);

    /**
     * 修改分数
     * @param id
     * @param languageScore
     * @return
     */
    Boolean upDateScore(Integer id, double languageScore);

    /**
     * 删除分数
     * @param id
     * @return
     */
    Boolean deleteScore(Integer id);

}
