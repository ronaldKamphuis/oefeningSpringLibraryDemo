package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.controller;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Partij;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.ArtiestRepository;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.PartijRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel: Stuurt de views van Partij aan
 */

@Controller
public class PartijController {

    @Autowired
    PartijRepository partijRepository;

    @Autowired
    ArtiestRepository artiestRepository;

    @GetMapping({"/", "/partijen"})
    protected String toonPartijen(Model model) {
        model.addAttribute("allePartijen", partijRepository.findAll());
        return "partijOverzicht";
    }

    @GetMapping("partij/{partijTitel}")
    protected String toonPartijDetails(Model model, @PathVariable("partijTitel") String partijTitel){
        Optional<Partij> partijMap = partijRepository.findByTitel(partijTitel);
        if (partijMap.isEmpty()) {
            return "redirect:/partijen";
        }
        model.addAttribute("partij",partijMap.get());
        return "partijDetails";
    }

    @GetMapping("/partijen/toevoegen")
    protected String toonPartijForm(Model model) {
        model.addAttribute("partij", new Partij());
        model.addAttribute("alleArtiesten", artiestRepository.findAll());
        return "partijForm";
    }

    @PostMapping("/partijen/toevoegen")
    protected String opslaanBijwerkenPartij(@ModelAttribute("partij") Partij partij, BindingResult result) {
        if (result.hasErrors()) {
            return "partijForm";
        } else {
            partijRepository.save(partij);
            return "redirect:/partijen";
        }
    }
}
