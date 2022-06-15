package io.github.kabosumy3a.eagerendeavorlove.service;

import io.github.kabosumy3a.eagerendeavorlove.domain.Member;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired  MemberRepository memberRepository ;
    @Autowired  MemberService memberService ;

    @Test
    //@Commit
    void 회원가입(){
        //given-when-then

        //given 어떤 데이터

        Member sungyu = new Member();
        sungyu.setName("baungyu");

        //when 어떤 상황
        memberService.join(sungyu);

        //then 어떤 결과
        Member member = memberService.findAllMembers()
                .stream()
                .filter(m -> m.getName().equals("baungyu"))
                .findAny()
                .orElse(null);

        assertThat(member.getId()).isEqualTo(sungyu.getId());
        assertThat(member.getName()).isEqualTo(sungyu.getName());
        assertThat(member).isNotEqualTo(null);
        //memory와 다르게 같은 객체는 아님
    }

    @Test
    void 중복_회원_예외() throws Exception{
        //given
        Member allen_black = new Member();
        Member allen_white = new Member();
        allen_black.setName("allen");
        allen_white.setName("allen");

        //when
        memberService.join(allen_black);

        //then
        int before = memberService.findNumMembers();

        //예외를 활용한 직접적인 테스트
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(allen_white));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //다른 방법이지만 직접적인 방법도 아니고 좋은 방법도 아니다
        //ex) Concurrent 상황일 경우
        int after = memberService.findNumMembers();
        assertThat(before).isEqualTo(after);

        System.out.println(before);
        System.out.println(after);

    }
}