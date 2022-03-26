package com.book.library.granter;

import com.book.library.domain.Order;
import com.book.library.domain.dto.UserOrderDTO;
import com.book.library.mapper.BookMapper;
import com.book.library.mapper.OrderMapper;
import com.book.library.utils.BeanUtils;
import com.book.library.utils.BigDecimalUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.book.library.granter.SilverMemberGranter.MEMBER_TYPE;


/**
 * 白银 订单总价*2
 */
@Component(MEMBER_TYPE)
public class SilverMemberGranter extends AbstractMemberGranter implements MemberGranter {

    public static final String MEMBER_TYPE = "silver";

    public SilverMemberGranter(BookMapper bookMapper, OrderMapper orderMapper) {
        super(bookMapper, orderMapper);
    }


    @Override
    public void buyBook(UserOrderDTO userOrderDTO) {
        List<Order> orders = BeanUtils.batchTransform(Order.class, userOrderDTO.getBookAndNumbers());
        orders.forEach(item->{
            item.setCreatedBy(userOrderDTO.getUserId());
            item.setCreateTime(LocalDateTime.now());
            BigDecimal oldPrice = BigDecimalUtils.mul(item.getPrice().toString(), item.getBookNum().toString());
            item.setPrice(BigDecimalUtils.mul(oldPrice.toString(),"0.8"));
        });
        orderMapper.insertBatch(orders);
        deductBook(userOrderDTO);
    }
}
