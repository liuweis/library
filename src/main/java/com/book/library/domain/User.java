package com.book.library.domain;

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
public class User extends Entity {

    private Integer userId;

    private String username;

    private String password;

    private Integer memberId;

    /**
     * 是否删除
     */
    private Integer isDelete;


}
