package com.book.library.granter;

import com.book.library.domain.Order;
import com.book.library.domain.dto.UserOrderDTO;
import com.book.library.mapper.BookMapper;
import com.book.library.mapper.OrderMapper;
import com.book.library.utils.BeanUtils;
import com.book.library.utils.BigDecimalUtils;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

import static com.book.library.granter.CopperMemberGranter.MEMBER_TYPE;

/**
 * 青铜 订单的总价格
 *
 * @author liuwei
 */
@Component(MEMBER_TYPE)
public class CopperMemberGranter extends AbstractMemberGranter implements MemberGranter {

    public static final String MEMBER_TYPE = "copper";

    public CopperMemberGranter(BookMapper bookMapper, OrderMapper orderMapper) {
        super(bookMapper, orderMapper);
    }


    @Override
    public void buyBook(UserOrderDTO userOrderDTO) {
        List<Order> orders = BeanUtils.batchTransform(Order.class, userOrderDTO.getBookAndNumbers());
        orders.forEach(item->{
            item.setCreatedBy(userOrderDTO.getUserId());
            item.setCreateTime(LocalDateTime.now());
            item.setPrice(BigDecimalUtils.mul(item.getPrice().toString(), item.getBookNum().toString()));
        });
        orderMapper.insertBatch(orders);
        deductBook(userOrderDTO);
    }


}
