package kabosumy3a.eelspringbasic.discount;

import kabosumy3a.eelspringbasic.member.Grade;
import kabosumy3a.eelspringbasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    int discountPercent = 10 ;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price * discountPercent / 100 ;
        return 0 ;
    }
}
