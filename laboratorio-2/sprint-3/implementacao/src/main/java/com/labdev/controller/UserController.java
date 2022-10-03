package com.labdev.controller;

import com.labdev.model.User;
import com.labdev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cadastrar() {
        return "user/create";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute User userModel) {
        var user = this.userRepository.save(userModel);
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editar(@RequestParam("id") long id, Model model) {
        var user = this.userRepository.findById(id);
        if(user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user/edit";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editar(@ModelAttribute User userModel) {
        var user = this.userRepository.save(userModel);
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") long id, Model model) {
        var user = this.userRepository.findById(id);
        user.ifPresent(value -> model.addAttribute("user", value));
        return "user/show";
    }
}
