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
public class Dictionary extends Entity {


  /**
   * 字典id
   */
    private Integer id;

  /**
   * 会员类型（1黄金2白银3普通）
   */
  private Integer memberType;

  /**
   * 会员名称
   */
  private String memberName;

  /**
   * 是否删除
   */
  private Integer isDelete;


}
