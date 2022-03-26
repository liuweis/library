package com.book.library.granter;

import com.book.library.domain.Order;
import com.book.library.domain.dto.UserOrderDTO;
import com.book.library.mapper.BookMapper;
import com.book.library.mapper.OrderMapper;
import com.book.library.utils.BeanUtils;
import com.book.library.utils.BigDecimalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.book.library.granter.GoldMemberGranter.MEMBER_TYPE;

/**
 * 黄金会员 订单总价*3 (三折还是七折有点不理解)
 *
 * @author liuwei
 */
@Component(MEMBER_TYPE)
@Slf4j
public class GoldMemberGranter extends AbstractMemberGranter implements MemberGranter {

    public static final String MEMBER_TYPE = "gold";

    public GoldMemberGranter(BookMapper bookMapper, OrderMapper orderMapper) {
        super(bookMapper, orderMapper);
    }


    @Override
    public void buyBook(UserOrderDTO userOrderDTO) {
        List<Order> orders = BeanUtils.batchTransform(Order.class, userOrderDTO.getBookAndNumbers());
        orders.forEach(item -> {
            item.setCreatedBy(userOrderDTO.getUserId());
            item.setCreateTime(LocalDateTime.now());
            BigDecimal oldPrice = BigDecimalUtils.mul(item.getPrice().toString(), item.getBookNum().toString());
            item.setPrice(BigDecimalUtils.mul(oldPrice.toString(), "0.7"));
        });
        orderMapper.insertBatch(orders);
        deductBook(userOrderDTO);
    }


}
