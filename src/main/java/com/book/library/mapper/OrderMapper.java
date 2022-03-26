package com.book.library.mapper;

import com.book.library.domain.Order;
import com.book.library.domain.User;
import com.book.library.domain.vo.OrderDetailVO;
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
public interface OrderMapper {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    void insertBatch(@Param("list") List<Order> list);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    void updateBatch(@Param("list") List<Order> list);

    /**
     * 查看订单
     * @param user
     * @return
     */
    List<OrderDetailVO> getOrderDetail(@Param("user") User user);


}
