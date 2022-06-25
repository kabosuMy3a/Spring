package io.github.kabosumy3a.eagerendeavorlove.repository;

import io.github.kabosumy3a.eagerendeavorlove.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
