package com.book.library.granter;

import com.book.library.domain.dto.UserOrderDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuwei
 * 支出订单
 */
public interface MemberGranter {


    /**
     * 买书
     * @param userOrderDTO
     */
    @Transactional(rollbackFor = Exception.class)
    void buyBook(UserOrderDTO userOrderDTO);

}
