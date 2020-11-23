package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.controller;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.LibraryUser;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel:
 */

@Controller
public class LibraryUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/user/new")
    protected  String showNewUserForm(Model model) {
        model.addAttribute("user", new LibraryUser());
        return "userForm";
    }

    @PostMapping("/user/new")
    protected String saveOrUpdateUser(@ModelAttribute("user") LibraryUser user, BindingResult result) {
        if (result.hasErrors()) {
            return  "userForm";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            libraryUserRepository.save(user);
            return "redirect:/";
        }
    }


}
