package kabosumy3a.eelspringbasic.order;

import kabosumy3a.eelspringbasic.discount.DiscountPolicy;
import kabosumy3a.eelspringbasic.discount.FixDiscountPolicy;
import kabosumy3a.eelspringbasic.discount.RateDiscountPolicy;
import kabosumy3a.eelspringbasic.member.Member;
import kabosumy3a.eelspringbasic.member.MemberRepository;
import kabosumy3a.eelspringbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy ;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
