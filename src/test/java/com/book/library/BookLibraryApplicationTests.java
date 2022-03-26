package com.book.library;

import com.book.library.domain.Book;
import com.book.library.domain.User;
import com.book.library.domain.dto.BookAndNumberDTO;
import com.book.library.domain.dto.UserOrderDTO;
import com.book.library.enums.MemberType;
import com.book.library.granter.MemberTypeBuilder;
import com.book.library.mapper.BookMapper;
import com.book.library.service.OrderService;
import com.book.library.utils.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.IntStream;

@SpringBootTest
class BookLibraryApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private MemberTypeBuilder memberTypeBuilder;

    @Test
    void findBookList() {
        System.out.println(bookMapper.findBookListById(Arrays.asList(1, 2)));
    }

    private static final Map<Integer, Integer> userMap = new HashMap<>(8);

    static {
        //key 用户id v会员信息
        userMap.put(1, 1);
        userMap.put(2, 2);
        userMap.put(3, 3);
    }

    public static void main(String[] args) {
        Integer id = RandomUtils.getRandomKeyFromMap(userMap);
        MemberType memberType = MemberType.getMemberType(id);
        System.out.println(memberType.getValue());
    }


    /**
     * 买书
     */
    @Test
    public void orderBook() {
        //这边就不登陆了，直接通过一个定义的map集合随机取用户信息
        Integer userId = RandomUtils.getRandomKeyFromMap(userMap);
        MemberType memberType = MemberType.getMemberType(userId);

        UserOrderDTO userOrderDTO = new UserOrderDTO();
        userOrderDTO.setUserId(userId);

        List<BookAndNumberDTO> bookAndNumbers = new ArrayList<>();
        List<Book> bookList = bookMapper.findBookList();

        //随机循环几次，也就是随机买几本书
        int randomInt = RandomUtils.getRandomInt(5);
        IntStream.range(0, randomInt == 0 ? 1 : randomInt).forEach(item -> {
            BookAndNumberDTO bookAndNumberDTO = new BookAndNumberDTO();
            //随机获取那本书
            Book book = RandomUtils.getRandomElement(bookList);
            //随机买那本书
            bookAndNumberDTO.setBookId(book.getBookId());
            //买几本
            int bookNum = RandomUtils.getRandomInt(5);
            bookAndNumberDTO.setBookNum(bookNum == 0 ? 1 : bookNum);
            bookAndNumberDTO.setPrice(book.getPrice());
            bookAndNumbers.add(bookAndNumberDTO);
        });
        userOrderDTO.setBookAndNumbers(bookAndNumbers);
        memberTypeBuilder.getMember(memberType.getValue()).buyBook(userOrderDTO);
    }


    /**
     * 获取订单明细
     */
    @Test
    public void getOrderList() {
        Integer userId = RandomUtils.getRandomKeyFromMap(userMap);
        User user = new User();
        user.setUserId(userId);
        System.out.println(orderService.getOrderDetail(user));
    }


}
