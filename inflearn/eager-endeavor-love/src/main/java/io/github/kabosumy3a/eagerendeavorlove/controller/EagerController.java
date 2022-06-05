package io.github.kabosumy3a.eagerendeavorlove.controller;

import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model ;
import org.springframework.web.bind.annotation.GetMapping ;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EagerController {

    Love love = new Love();

    @GetMapping("eager")
    public String eager(Model model){
        model.addAttribute("data", "eager for me");
        return "eager";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "age", required = false) int  age,
                           Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hello-template";

    }

    @GetMapping("endeavor")
    @ResponseBody
    public String endeavor(@RequestParam(name = "for", required = false) String for_what){
        return "endeavor for " + for_what + " " + love.getWhat() ;
    }

    @GetMapping("love-api")
    @ResponseBody
    public Love loveApi(@RequestParam("what") String what){
        love.setWhat(what);
        return love;
    }

    static class Love {
        private String what ;
        private String hi ;

        public String getWhat(){
            return what ;
        }

        public void setWhat(String what) {
            this.what = what;
        }

        public String getHi() {
            return hi;
        }

        public void setHi(String hi) {
            this.hi = hi;
        }
    }

}


//spring-boot-devtools ; 서버 재시작 안해도 됨 ;
