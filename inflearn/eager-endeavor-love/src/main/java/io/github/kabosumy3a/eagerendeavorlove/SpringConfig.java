package io.github.kabosumy3a.eagerendeavorlove;

import io.github.kabosumy3a.eagerendeavorlove.repository.JdbcMemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemoryMemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource ; //forJDBC

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
