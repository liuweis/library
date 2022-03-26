package com.book.library.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author earl.liu
 * @date 2022/3/25 下午5:18
 */
@Data
public class BookAndNumberDTO implements Serializable {

    private Integer bookId;

    private Integer bookNum;

    private BigDecimal price;



}
