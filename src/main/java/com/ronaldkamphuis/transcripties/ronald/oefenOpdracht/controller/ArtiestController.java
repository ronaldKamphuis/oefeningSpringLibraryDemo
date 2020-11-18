package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.controller;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Artiest;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.ArtiestRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ArtiestController {

    @Autowired
    ArtiestRepository artiestRepository;

    @GetMapping("/artiesten")
    protected String toonArtiesten(Model model) {
        model.addAttribute("alleArtiesten", artiestRepository.findAll());
        model.addAttribute("artiest",new Artiest());
        return "artiestOverzicht";
    }

    @PostMapping("/artiest/toevoegen")
    protected String opslaanBijwerkenArtiest(@ModelAttribute("artiest") Artiest artiest, BindingResult result) {
        if (result.hasErrors()) {
            return  "artiestOverzicht";
        } else {
            artiestRepository.save(artiest);
            return "redirect:/artiesten";
        }
    }
}
