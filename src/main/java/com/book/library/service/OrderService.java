package com.book.library.service;

import com.book.library.domain.User;
import com.book.library.domain.vo.OrderDetailVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuwei
 * @since 2022-03-25
 */
public interface OrderService{


    /**
     * 订单详情
     * @param user
     * @return
     */
    List<OrderDetailVO> getOrderDetail(User user);


}
