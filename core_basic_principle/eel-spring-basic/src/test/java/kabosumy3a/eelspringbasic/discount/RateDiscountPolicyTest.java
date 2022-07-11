package kabosumy3a.eelspringbasic.discount;

import kabosumy3a.eelspringbasic.member.Grade;
import kabosumy3a.eelspringbasic.member.Member;
import kabosumy3a.eelspringbasic.member.MemberService;
import kabosumy3a.eelspringbasic.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 할인 10퍼")
    void RatioTestVIP(){
        Member memberVIP = new Member(1L, "sungyu", Grade.VIP);
        assertThat(discountPolicy.discount(memberVIP, 200)).isEqualTo(20);

    }

    @Test
    @DisplayName(("Basic은 할인 0원"))
    void RatioTestBasic(){
        Member memberBasic = new Member(2L, "ss", Grade.BASIC);
        assertThat(discountPolicy.discount(memberBasic, 1000)).isEqualTo(0);
    }
}