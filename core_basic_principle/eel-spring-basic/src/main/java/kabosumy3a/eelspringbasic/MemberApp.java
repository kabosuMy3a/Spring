package kabosumy3a.eelspringbasic;

import kabosumy3a.eelspringbasic.member.Grade;
import kabosumy3a.eelspringbasic.member.Member;
import kabosumy3a.eelspringbasic.member.MemberService;
import kabosumy3a.eelspringbasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "sungyu", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new " + member.getName());
        System.out.println("find " + findMember.getName());
    }
}
