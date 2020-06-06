package com.question.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.question.dto.DataGridView;
import com.question.entity.Question;
import com.question.entity.User;
import com.question.service.QuestionService;
import com.question.service.UserService;
import com.question.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Ye
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @GetMapping("/index_info")
    public DataGridView index(QuestionVO questionVO) {
        Page<Question> page = new Page<>(questionVO.getPage(), questionVO.getLimit());
        questionService.page(page);

        DataGridView dataGridView = new DataGridView();
        dataGridView.setCode(0L);
        dataGridView.setMsg("success");
        dataGridView.setCount(page.getTotal());
        HashMap<Object, Object> map = new HashMap<>();
        List<Question> records = page.getRecords();
        ArrayList<Object> list = new ArrayList<>();
        for (Question record : records) {
            HashMap<Object, Object> map1 = new HashMap<>();
            User user = userService.findByAccountId(record.getCreator());
            map1.put("question", record);
            map1.put("user", user);
            list.add(map1);
        }
        map.put("list", list);

        dataGridView.setData(map);
//        dataGridView.setData(page.getRecords());
        return dataGridView;


    }

    @GetMapping("/question_info")
    public DataGridView question(QuestionVO questionVO) {
        Page<Question> page = new Page<>(questionVO.getPage(), questionVO.getLimit());
        questionService.page(page);

        DataGridView dataGridView = new DataGridView();
        dataGridView.setCode(0L);
        dataGridView.setMsg("success");
        dataGridView.setCount(page.getTotal());
        dataGridView.setData(page.getRecords());
        return dataGridView;


    }

    @PostMapping("/editQuestion")
    public DataGridView editQuestion(QuestionVO questionVO) {
        if (questionVO.getTitle() == null && questionVO.getDescription() == null && questionVO.getTag() == null) {
            return new DataGridView(1L, "你编辑的信息不能为空", 0L);
        }
        try {
            questionService.updateById(questionVO);
            return new DataGridView(0L, "修改成功", 1L);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGridView(1L, "修改失败", 0L);
        }


    }

    @PostMapping("/deleteQuestionById")
    public DataGridView deleteQuestionById(QuestionVO questionVO) {
        try {
            questionService.removeById(questionVO.getId());
            return new DataGridView(0L, "删除成功", 1L);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataGridView(1L, "删除失败", 0L);
        }
    }
}

