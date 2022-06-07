package io.github.kabosumy3a.eagerendeavorlove.repository;
import io.github.kabosumy3a.eagerendeavorlove.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.List;
import static org.assertj.core.api.Assertions.* ;

class MemoryMemberRepositoryTest  {
    //Class로 실행하면 method 호출 순서 사전순인듯 ;

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Sungyu");
        repository.save(member);
        Member rst = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, rst) ;
    }

    @Test
    public void wrong_save(){
        Member member = new Member();
        member.setName("Sungi");
        repository.save(member);
        Member rst = repository.findById(1l).orElse(null);
        assertThat(rst).isEqualTo(member).isNotEqualTo(null);
    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("allen");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("white");
        repository.save(member2);

        Member rst = repository.findByName("alle").orElse(null);
        assertThat(rst).isEqualTo(null );
        //assertThat(rst).isNotEqualTo(member2);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("jeremy");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("somma");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isGreaterThanOrEqualTo(2);

    }

}
