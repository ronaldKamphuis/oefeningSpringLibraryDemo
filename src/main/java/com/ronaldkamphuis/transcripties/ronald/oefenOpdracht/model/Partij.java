package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel: partij (transcriptie) uit de verzameling weergeven
 */

@Entity
public class Partij {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer partijId;
    private String titel;
    private Double prijs;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artiestId", referencedColumnName = "artiestId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Artiest artiest;

    @OneToMany(mappedBy = "partij")
    private List<Exemplaar> exemplaren;

    public int getAantalExemplaren() {
        return exemplaren.size();
    }

    public Integer getPartijId() {
        return partijId;
    }

    public void setPartijId(Integer partijId) {
        this.partijId = partijId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public void setArtiest(Artiest artiest) {
        this.artiest = artiest;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }
}
