package com.illia.controller;

import com.illia.configuration.SocialConfig;
import com.illia.model.User;
import com.illia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private Facebook facebook;



    /*Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
    facebook = connection != null ? connection.getApi() : null;*/

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView vm) {
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, ModelAndView vm) {
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) {
        vm.setViewName("signup");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute User user, ModelAndView vm) {
        vm.setViewName("welcome");
        vm.addObject("user", userService.addUser(user));
        return vm;
    }


    @RequestMapping(path = "/social")
    public String helloFacebook(ModelAndView vm) {
        return "social";

    }



}
