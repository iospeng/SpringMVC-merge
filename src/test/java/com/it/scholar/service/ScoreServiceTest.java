package com.it.scholar.service;

import com.it.scholar.config.SpringConfig;
import com.it.scholar.domain.Score;
import com.it.scholar.service.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //指定执行测试的运行类，由该类执行测试
@ContextConfiguration(classes = SpringConfig.class) // 指定Spring的配置文件因为测试的service类是在Spring环境下的，所以指定的是Spring的配置文件
public class ScoreServiceTest {
    @Autowired
    private ScoreService scoreService;

    @Test
    public void testGetById(){
        Score score = scoreService.findByID(1);
        System.out.println(score);
    }
    
    @Test
    public void testGetAll(){
        List<Score> scores = scoreService.selectAll();
        System.out.println(scores);
    }
}
