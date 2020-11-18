package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Ronald Kamphuis <info@ronaldkamphuis.com>
 * Opdracht:
 * Doel: Exemplarische verschillen van een partij
 */

@Entity
public class Exemplaar {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exemplaarId;

    private Boolean tablatuur = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "partijId", referencedColumnName = "partijId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Partij partij;

    public Integer getExemplaarId() {
        return exemplaarId;
    }

    public void setExemplaarId(Integer exemplaarId) {
        this.exemplaarId = exemplaarId;
    }

    public Boolean getTablatuur() {
        return tablatuur;
    }

    public void setTablatuur(Boolean video) {
        this.tablatuur = video;
    }

    public Partij getPartij() {
        return partij;
    }

    public void setPartij(Partij partij) {
        this.partij = partij;
    }
}
