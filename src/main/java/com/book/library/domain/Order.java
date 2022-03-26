package com.book.library.domain;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author liuwei
 * @since 2022-03-25
 */
@Data
@Accessors
@EqualsAndHashCode(callSuper = true)
public class Order extends Entity {


    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 图书id
     */
    private Integer bookId;

    /**
     * 图书数量
     */
    private Integer bookNum;

    /**
     * 成交价格
     */
    private BigDecimal price;


}
