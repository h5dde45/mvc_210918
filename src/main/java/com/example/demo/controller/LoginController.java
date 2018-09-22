package com.example.demo.controller;

import com.example.demo.objects.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute
    public User getUser() {
        return new User();
    }

    @GetMapping("/")
    public ModelAndView login(@ModelAttribute User user) {
        user.setUsername("username2");
        return new ModelAndView("login", "user", user);
    }

    @PostMapping("/check-user")
    public String checkUser(@Valid @ModelAttribute("user") User user,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);
            return "/login";
        }

        return "main";
    }

    @GetMapping(value = "/get-json-user/{username}/{admin}", produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable("username") String username,
                            @PathVariable("admin") boolean admin) {
        User user = new User();
        user.setUsername(username);
        user.setAdmin(admin);
        return user;
    }

    @PostMapping(value = "/put-json-user", consumes = "application/json")
    public ResponseEntity<String> setJsonUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
