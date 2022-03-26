package com.book.library.granter;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author liuwei
 */
@Component
public class MemberTypeBuilder {

    private final Map<String, MemberGranter> memberPool = new ConcurrentHashMap<>();

    public MemberTypeBuilder(Map<String, MemberGranter> granterPool) {
        granterPool.forEach(this.memberPool::put);
    }


    public MemberGranter getMember(String memberType) {
        MemberGranter memberGranter = memberPool.get(memberType);
        if (memberGranter == null) {
            throw new RuntimeException("会员类型不支持！请确认后重试");
        }

        return memberGranter;
    }

}
