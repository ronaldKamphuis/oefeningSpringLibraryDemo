package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.controller;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Exemplaar;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Partij;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.ExemplaarRepository;
import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository.PartijRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel:
 */

@Controller
public class ExemplaarController {

    @Autowired
    PartijRepository partijRepository;

    @Autowired
    ExemplaarRepository exemplaarRepository;

    @GetMapping("/exemplaar/toevoegen/{partijId}")
    protected String voegToeExemplaar(@PathVariable("partijId") Integer partijId) {
        Optional<Partij> partijMap = partijRepository.findById(partijId);
        if (partijMap.isPresent()) {
            Exemplaar exemplaar = new Exemplaar();
            exemplaar.setPartij((partijMap.get()));
            exemplaarRepository.save(exemplaar);
        }
        return "redirect:/partijen";
    }

    @GetMapping("/exemplaar/toevoegen/p/{partijTitel}")
    protected String voegToeExemplaarPerTitel(@PathVariable("partijTitel") String partijTitel) {
        Optional<Partij> partijMap = partijRepository.findByTitel(partijTitel);
        if (partijMap.isPresent()) {
            Exemplaar exemplaar = new Exemplaar();
            exemplaar.setPartij((partijMap.get()));
            exemplaarRepository.save(exemplaar);
        }
        return "redirect:/partijen";
    }

    @GetMapping("/exemplaar/verwijderen/p/{partijTitel}")
    protected String verwijderExemplaarPerTitel(@PathVariable("partijTitel") String partijTitel) {
        System.out.println("Verwijder partij");
        Optional<Partij> partijMap = partijRepository.findByTitel(partijTitel);
        Exemplaar exemplaar = new Exemplaar();
        exemplaar.setPartij((partijMap.get()));
        exemplaarRepository.delete(exemplaar);
        System.out.println("Einde verwijder methode");
        return "redirect:/partijen";
    }
//        if (partijMap.isPresent()) {
//            Exemplaar exemplaar = new Exemplaar();
//            exemplaar.setPartij((partijMap.get()));
//            exemplaarRepository.delete(exemplaar);
//        }
//        return "redirect:/partijen";
}

