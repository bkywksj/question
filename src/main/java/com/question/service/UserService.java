package com.question.service;

import com.question.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ye
 * @since 2020-06-04
 */
public interface UserService extends IService<User> {

    User findByToken(String token);

    User findByAccountId(String creator);
}
