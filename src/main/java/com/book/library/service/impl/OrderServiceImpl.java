package com.book.library.service.impl;

import com.book.library.domain.User;
import com.book.library.domain.vo.OrderDetailVO;
import com.book.library.mapper.OrderMapper;
import com.book.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author earl.liu
 * @date 2022/3/25 下午4:26
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<OrderDetailVO> getOrderDetail(User user) {
        return orderMapper.getOrderDetail(user);
    }
}
