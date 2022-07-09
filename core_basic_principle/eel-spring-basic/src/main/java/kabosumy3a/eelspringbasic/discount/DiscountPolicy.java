package kabosumy3a.eelspringbasic.discount;

import kabosumy3a.eelspringbasic.member.Member;

public interface DiscountPolicy {

    //return 할인 대상 금액
    int discount(Member member, int price);
}
