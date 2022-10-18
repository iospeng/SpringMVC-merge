package com.it.scholar.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.it.scholar.customException.BusinessException;
import com.it.scholar.customException.SystemException;
import com.it.scholar.domain.RequestResultsCode;
import com.it.scholar.domain.ResponseData;
import com.it.scholar.domain.Score;
import com.it.scholar.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.it.scholar.domain.RequestResultsCode.REQUEST_ERR;
import static com.it.scholar.domain.RequestResultsCode.REQUEST_OK;

@Controller
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 按id查询分数
     *
     * @RequestMapping:设置接口访问路径
     * @ResponseBody：设置方法返回值类型就是响应数据类型
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    @ResponseBody
    public ResponseData findById(Integer id){
        if(id == 1){
            throw new SystemException(500,"请求超时，请重试！");
        }
        if (id == 2){
            throw new BusinessException(500,"id不存在");
        }
        Score scorebyID = scoreService.findByID(id);
        Integer code = scorebyID != null ? REQUEST_OK : REQUEST_ERR;
        String msg = scorebyID != null ? "查询成功！" : "查询失败，请重试！";
        return new ResponseData(code,scorebyID,msg);
    }

    /**
     * 查询所有分数
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public ResponseData findAll(){
        List<Score> scores = scoreService.selectAll();
        Integer code = scores != null ? REQUEST_OK : REQUEST_ERR;
        String msg = scores != null ? "查询成功！" : "查询失败，请重试！";
        return new ResponseData(code,scores,msg);
    }

    /**
     * 新增分数
     * 请求接口时以json格式传参
     * @RequestBody:设置接收的参数是在请求体中，并且是json格式
     * @param score
     * @return
     */
    @RequestMapping("/insertScore")
    @ResponseBody
    public ResponseData insertScore(@RequestBody Score score){
        Boolean aBoolean = scoreService.insertScore(score);
        Integer code = aBoolean ? REQUEST_OK : REQUEST_ERR;
        String msg = aBoolean ? "新增成功！" : "新增失败请重试！";
        return new ResponseData(code,aBoolean,msg);
    }

    /**
     * 修改分数
     * 多个 散装参数 需注意dao层接口中 sql 参数与接口形参的对应关系，使用@Param注解标识形参
     * @param id
     * @param languageScore
     * @return
     */
    @RequestMapping("/upDateScore")
    @ResponseBody
    public ResponseData upDateScore(Integer id, double languageScore){
        Boolean aBoolean = scoreService.upDateScore(id, languageScore);
        Integer code = aBoolean ? REQUEST_OK : REQUEST_ERR;
        String msg = aBoolean ? "更新成功" : "更新失败，请重试！";
        return new ResponseData(code, aBoolean, msg);
    }

    /**
     * 按id删除分数
     * @param id
     * @return
     */
    @RequestMapping("/deleteScore")
    @ResponseBody
    public ResponseData deleteScore( Integer id){
        Boolean aBoolean = scoreService.deleteScore(id);
        Integer code = aBoolean ? REQUEST_OK : REQUEST_ERR;
        String msg = aBoolean ? "删除成功" : "删除失败，请重试！";
        return new ResponseData(code, aBoolean, msg);
    }
}
