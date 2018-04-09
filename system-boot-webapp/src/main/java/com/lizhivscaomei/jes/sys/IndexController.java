package com.lizhivscaomei.jes.sys;

import com.lizhivscaomei.jes.sys.security.userdetails.JesUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by lizhi on 2018/3/30.
 */
@Controller
public class IndexController {
    @GetMapping(value = {"","/","/home","/index","/welcome"})
    public ModelAndView index(HttpSession session){
        ModelAndView mv = new ModelAndView("index");
        JesUserDetails jesUserDetails= (JesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mv.addObject("user",jesUserDetails);
        return mv;
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
