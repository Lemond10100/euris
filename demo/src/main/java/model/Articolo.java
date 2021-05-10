package model;

import util.IMappable;

import java.util.List;

public class Articolo implements IMappable {


    private int id;
    private String nome;
    private int schelling;
    private int pence;
    private int pound;


    public Articolo(int id, String nome, int schelling, int pence, int pound) {
        this.id = id;
        this.nome = nome;
        this.schelling = schelling;
        this.pence = pence;
        this.pound = pound;
    }

    public Articolo() {
    }


    public int ArticoloToPence () {
        int unoPoundToSchelling = this.pound * 20;
        int unoSchellingToPence =  (this.schelling  + unoPoundToSchelling) * 12;
        int unoTotPence =  unoSchellingToPence + this.pence;

        return unoTotPence;
    }



/*
    public String prezzoArticoloToPence () {
        int PoundToSchelling = this.pound * 20;
        int SchellingToPence =  (this.schelling  + PoundToSchelling) * 12;
        int totPence =  SchellingToPence + this.pence;

      String tot = "" + totPence;

      return tot;
    }

*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSchelling() {
        return schelling;
    }

    public void setSchelling(int schelling) {
        this.schelling = schelling;
    }

    public int getPence() {
        return pence;
    }

    public void setPence(int pence) {
        this.pence = pence;
    }

    public int getPound() {
        return pound;
    }

    public void setPound(int pound) {
        this.pound = pound;
    }
}
