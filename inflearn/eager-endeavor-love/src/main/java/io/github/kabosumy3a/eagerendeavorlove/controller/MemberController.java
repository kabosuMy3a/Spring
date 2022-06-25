package io.github.kabosumy3a.eagerendeavorlove.controller;

import io.github.kabosumy3a.eagerendeavorlove.domain.Member;
import io.github.kabosumy3a.eagerendeavorlove.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // DI의 3가지 방법, 그러나 생성자 주입만을 사용

    /*
    필드 주입
    필드 주입은 안 좋음. 왜?? 바꿀 수 있는 방법이 없다.
    @Autowired private MemberService memberService ;
    */

    /*
    setter 주입
    setter 주입은 가장 좋지 않음. 왜?? 바꿀 이유가 없는데 set 함수가 public 하게 노출
    필드 주입 단점이랑 대치되는데 ?

    private MemberService memberService ;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */

    //생성자 주입 - 주로 사용
    private final MemberService memberService ;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("***"+ memberService.getClass());
    }

    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm" ;
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/"; //홈 화면으로
    }

    @GetMapping("/members")
    public String memberList(Model model){
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "members/memberList"; 
    }


}
