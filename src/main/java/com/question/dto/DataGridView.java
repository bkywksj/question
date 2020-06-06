package com.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * layui回显的json格式所必需的条件
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {

    private Long code = 0L;
    private String msg = "";
    private Long count;
    private Object data;

    public DataGridView(Long code,String msg,Long count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
    }
}
