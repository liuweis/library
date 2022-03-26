package com.book.library.controller;

import com.book.library.domain.User;
import com.book.library.domain.dto.UserOrderDTO;
import com.book.library.domain.vo.OrderDetailVO;
import com.book.library.granter.MemberTypeBuilder;
import com.book.library.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuwei
 * @since 2022-03-25
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单模块")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberTypeBuilder memberTypeBuilder;

    @GetMapping("getOrderDetail")
    @ApiOperation(value = "订单明细")
    public List<OrderDetailVO> findBookList(User user) {
        return orderService.getOrderDetail(user);
    }

    @PostMapping("buyBook")
    @ApiOperation(value = "买书")
    public void buyBook(@RequestBody UserOrderDTO userOrderDTO) {
        memberTypeBuilder.getMember(userOrderDTO.getMemberType()).buyBook(userOrderDTO);
    }


}

