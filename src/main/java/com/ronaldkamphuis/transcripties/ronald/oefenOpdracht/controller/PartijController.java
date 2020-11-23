package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.controller;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Partij;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.ArtiestRepository;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.PartijRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "partijOverzicht";

        try {
            partijRepository.saveImage(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            returnValue = "Er is iets fout gegaan";
        }
        return returnValue;
    }
}
