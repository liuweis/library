package com.book.library.mapper;

import com.book.library.domain.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liuwei
 * @since 2022-03-25
 */
@Repository
public interface BookMapper {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    void insertBatch(@Param("list") List<Book> list);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    void updateBatch(@Param("list") List<Book> list);

    /**
     * 修改图书剩余数量
     *
     * @param books
     */
    void updateBookNum(@Param("list") List<Book> books);


    List<Book> findBookListById(@Param("id") List<Integer> id);


    List<Book> findBookList();



}
