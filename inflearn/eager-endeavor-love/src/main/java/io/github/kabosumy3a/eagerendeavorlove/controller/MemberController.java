package io.github.kabosumy3a.eagerendeavorlove.controller;

import io.github.kabosumy3a.eagerendeavorlove.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService ;

    //@Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
