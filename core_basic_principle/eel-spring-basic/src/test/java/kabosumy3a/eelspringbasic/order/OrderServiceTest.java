package kabosumy3a.eelspringbasic.order;

import kabosumy3a.eelspringbasic.member.Grade;
import kabosumy3a.eelspringbasic.member.Member;
import kabosumy3a.eelspringbasic.member.MemberService;
import kabosumy3a.eelspringbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrderTest(){
        //Given
        Long memberId = 1L ;
        Member member = new Member(1L, "sungyu", Grade.VIP);
        memberService.join(member);

        //When
        Order order = orderService.createOrder(memberId, "lemon", 980);
        //Then
        Assertions.assertThat(order.calculatePrice()).isEqualTo(0);
    }
}
