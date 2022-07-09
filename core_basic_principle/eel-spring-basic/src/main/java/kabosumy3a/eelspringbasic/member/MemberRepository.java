package kabosumy3a.eelspringbasic.member;

public interface MemberRepository {
    void save(Member member) ;

    Member findById(Long memberId);
}
