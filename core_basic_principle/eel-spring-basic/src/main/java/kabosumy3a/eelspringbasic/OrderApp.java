package kabosumy3a.eelspringbasic;

import kabosumy3a.eelspringbasic.member.Grade;
import kabosumy3a.eelspringbasic.member.Member;
import kabosumy3a.eelspringbasic.member.MemberService;
import kabosumy3a.eelspringbasic.member.MemberServiceImpl;
import kabosumy3a.eelspringbasic.order.Order;
import kabosumy3a.eelspringbasic.order.OrderService;
import kabosumy3a.eelspringbasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L ;
        Member member= new Member(memberId, "sungyu", Grade.VIP);
        memberService.join(member);

        Order order= orderService.createOrder(member.getId(), "레몬", 980);
        System.out.println(order);
    }
}
