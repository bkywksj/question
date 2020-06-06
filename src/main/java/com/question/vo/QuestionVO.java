package com.question.vo;

import com.question.entity.Question;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
 *
 *@author Ye
 *@create 2020/6/4 13:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QuestionVO extends Question {
    @ApiModelProperty(value = "第几页")
    private Integer page = 1;

    @ApiModelProperty(value = "每页显示多少条")
    private Integer limit = 10;

}
