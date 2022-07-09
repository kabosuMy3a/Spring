package kabosumy3a.eelspringbasic.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //give

        Member member = new Member(1L, "sungyu", Grade.BASIC);

        //when

        memberService.join(member);
        Member inMemoryMember = memberService.findMember(1L);

        //Then
        assertThat(member).isEqualTo(inMemoryMember);

    }
}
