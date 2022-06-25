package io.github.kabosumy3a.eagerendeavorlove;

import io.github.kabosumy3a.eagerendeavorlove.repository.*;
import io.github.kabosumy3a.eagerendeavorlove.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    //private final EntityManager em ;

    private final MemberRepository memberRepository ;
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository ;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


    /*
    private DataSource dataSource ; //forJDBC

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */
    /*

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */


    /*
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
    }
     */
}
