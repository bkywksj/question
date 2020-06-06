package com.question.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.question.dto.DataGridView;
import com.question.entity.Question;
import com.question.entity.User;
import com.question.service.UserService;
import com.question.vo.QuestionVO;
import com.question.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ye
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user_info")
    public DataGridView question(UserVO userVO) {
        Page<User> page = new Page<>(userVO.getPage(), userVO.getLimit());
        userService.page(page);
        DataGridView dataGridView = new DataGridView();
        dataGridView.setCode(0L);
        dataGridView.setMsg("success");
        dataGridView.setCount(page.getTotal());
        dataGridView.setData(page.getRecords());
        return dataGridView;

    }
}

