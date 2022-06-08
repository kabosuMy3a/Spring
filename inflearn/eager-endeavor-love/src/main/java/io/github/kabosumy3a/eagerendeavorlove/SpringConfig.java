package io.github.kabosumy3a.eagerendeavorlove;

import io.github.kabosumy3a.eagerendeavorlove.repository.MemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemoryMemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(); 
    }
}
