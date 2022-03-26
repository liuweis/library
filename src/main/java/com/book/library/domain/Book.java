package com.book.library.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Book extends Entity {

    /**
     * 图书号
     */
    private Integer bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 出版日期
     */
    private LocalDateTime publishDate;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 图书类型（目前不定义）
     */
    private String bookType;

    /**
     * 存放位置
     */
    private String storeLocation;

    /**
     * 入库日期
     */
    private LocalDateTime storeDate;

    /**
     * 借出数量
     */
    private Integer borrowedNumber;

    /**
     * 图书剩余数量
     */
    private Integer number;


}
