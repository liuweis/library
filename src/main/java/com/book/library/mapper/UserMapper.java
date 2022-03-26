package com.book.library.mapper;

import com.book.library.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liuwei
 * @since 2022-03-25
 */
@Repository
public interface UserMapper {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    void insertBatch(@Param("list") List<User> list);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    void updateBatch(@Param("list") List<User> list);
}
