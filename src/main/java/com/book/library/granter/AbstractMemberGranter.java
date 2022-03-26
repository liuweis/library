package com.book.library.granter;

import com.book.library.domain.Book;
import com.book.library.domain.dto.BookAndNumberDTO;
import com.book.library.domain.dto.UserOrderDTO;
import com.book.library.mapper.BookMapper;
import com.book.library.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *扣除库存
 * @author liuwei
 */
@Slf4j
@RequiredArgsConstructor
public abstract class AbstractMemberGranter implements MemberGranter {

    protected final BookMapper bookMapper;
    protected final OrderMapper orderMapper;

    /**
     * 扣除图书的数量
     *
     * @param userOrderDTO
     */
    protected void deductBook(UserOrderDTO userOrderDTO) {
        //验证bookAndNumbers是否为空
        List<BookAndNumberDTO> bookAndNumbers = userOrderDTO.getBookAndNumbers();
        List<Integer> bookId = bookAndNumbers.stream().map(BookAndNumberDTO::getBookId).collect(Collectors.toList());
        //查看所有的图书
        List<Book> bookList = bookMapper.findBookListById(bookId);
        if (null == bookList || bookList.size() == 0) {
            //后端增加校验，按理说售磬的前端要置灰
            throw new RuntimeException("书已经售磬，请确认后重试！");
        }
        //订购的订单
        Map<Integer, List<BookAndNumberDTO>> orderBook = bookAndNumbers.stream().collect(Collectors.groupingBy(BookAndNumberDTO::getBookId));

        bookList.forEach(item -> {
            List<BookAndNumberDTO> bookAndNumberS = orderBook.get(item.getBookId());
            item.setNumber(item.getNumber() - bookAndNumberS.get(0).getBookNum());
            item.setBorrowedNumber(item.getBorrowedNumber() + bookAndNumberS.get(0).getBookNum());
        });
        //图书表扣减
        bookMapper.updateBookNum(bookList);
    }


}
