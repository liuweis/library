package com.book.library.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author earl.liu
 * @date 2022/3/26 上午8:19
 */
@Data
public class UserOrderDTO implements Serializable {
    private Integer userId;

    @ApiModelProperty("会员类型")
    private String memberType;

    private List<BookAndNumberDTO> bookAndNumbers;
}
