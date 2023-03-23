package com.all.in.one.allinOne.controller;

import com.all.in.one.allinOne.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Validated
public class LoginController {

    @PostMapping("sign-in")
    public String signIn(@RequestBody @Valid LoginRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("username", request.getUsername());
        redirectAttributes.addAttribute("password", request.getPassword());
        return "redirect:/login";
    }

}
