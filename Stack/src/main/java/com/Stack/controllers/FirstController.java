package com.Stack.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Stack.models.Person;

@Controller
public class FirstController {

    @GetMapping("/test1")
    @ResponseBody
    public String printHello() {
        return "Hello World";
    }

    @GetMapping("/test2")
    public String showHelloPage(Model model) {
        model.addAttribute("message", "Have a great day!");
        return "helloPage";
    }

    @GetMapping("/test3")
    public ModelAndView printHelloAgain() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Have a super duper day!");
        mv.addObject("rating", 55);
        mv.setViewName("helloPage");
        return mv;
    }

    @GetMapping("/test4")
    public String showHelloPage4(@RequestParam("message") String message, Model model) {
        model.addAttribute("message", message);
        return "helloPage";
    }

    @GetMapping("/people")
    public String showFriends(Model model) {

        List<Person> friends = new ArrayList<Person>();

        friends.add(new Person(0, "Allen", 23, 142.2f));
        friends.add(new Person(1, "Barrack", 44, 444.4f));
        friends.add(new Person(2, "Connor McGregor", 2, 50.2f));
        friends.add(new Person(3, "David", 9, 100.4f));

        System.out.println(friends);

        model.addAttribute("people", friends);
        return "printFriends.html";
    }

    @GetMapping("/peopleJSON")
    @ResponseBody
    public List<Person> showFriendsJSON(Model model) {

        List<Person> friends = new ArrayList<Person>();

        friends.add(new Person(0, "Allen", 23, 142.2f));
        friends.add(new Person(1, "Barrack", 44, 444.4f));
        friends.add(new Person(2, "Connor McGregor", 2, 50.2f));
        friends.add(new Person(3, "David", 9, 100.4f));

        System.out.println(friends);

        model.addAttribute("people", friends);
        return friends;
    }
}
