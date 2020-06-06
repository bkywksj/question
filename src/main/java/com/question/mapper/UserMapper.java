package com.question.mapper;

import com.question.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ye
 * @since 2020-06-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User findByToken(String token);

    User findByAccountId(String creator);
}
