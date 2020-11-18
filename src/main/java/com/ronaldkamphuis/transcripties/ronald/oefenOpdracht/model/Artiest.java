package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel: Uitvoerende artiest van een transcriptie
 */

@Entity
public class Artiest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer artiestId;

    private String naam;

    @OneToMany(mappedBy = "artiest")
    private List<Partij> mijnPartijen;

    public Integer getArtiestId() {
        return artiestId;
    }

    public void setArtiestId(Integer artiestId) {
        this.artiestId = artiestId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalPartijen() {
        return mijnPartijen.size();
    }
}
