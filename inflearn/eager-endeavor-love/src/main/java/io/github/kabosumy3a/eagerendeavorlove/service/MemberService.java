package io.github.kabosumy3a.eagerendeavorlove.service;

import io.github.kabosumy3a.eagerendeavorlove.domain.Member;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemberRepository;
import io.github.kabosumy3a.eagerendeavorlove.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository ;
    }

    public Long join(Member member){
        validateDuplicaiteMember(member);
        memberRepository.save(member);
        return member.getId() ;
    }

    private void validateDuplicaiteMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOneMemberByMemberID(Long memberID){
        return memberRepository.findById(memberID);
    }

    public int findNumMembers(){
        return memberRepository.findNumMembers() ;
    }

}
