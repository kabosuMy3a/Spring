package io.github.kabosumy3a.eagerendeavorlove.repository;

import io.github.kabosumy3a.eagerendeavorlove.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em ;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //jpql
        return em.createQuery("select m from Member as m", Member.class)
                .getResultList();
    }

    /*
    @Override
    public int findNumMembers() {
        return 0;
    }

    @Override
    public void clearStore() {

    }
     */
}
