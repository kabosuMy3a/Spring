package kabosumy3a.eelspringbasic.discount;

import kabosumy3a.eelspringbasic.member.Grade;
import kabosumy3a.eelspringbasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    int discountFixAmount = 1000 ;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return discountFixAmount ;

        return 0 ;
    }
}
