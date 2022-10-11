package com.it.scholar.controller;

import com.it.scholar.domain.Score;
import com.it.scholar.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/findById")
    @ResponseBody
    public Score findById(Integer id){
        return scoreService.findByID(id);
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Score> findAll(){
        return scoreService.selectAll();
    }
}
