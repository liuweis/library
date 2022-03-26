package com.book.library.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author earl.liu
 * @date 2022/3/26 上午11:23
 */
@Data
public class OrderDetailVO implements Serializable {

    private String username;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String bookName;
    private Integer bookNum;


}
