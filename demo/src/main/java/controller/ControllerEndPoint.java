package controller;


import dao.IDaoLayer;
import model.Articolo;
import model.GestionaleOperazioni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class ControllerEndPoint {
    @Autowired
    private IDaoLayer dao;


    GestionaleOperazioni gestionaleOperazioni;


    @GetMapping("/{articoli}")
    public List<Articolo> catalogo () {
        return dao.listaArticoli();
    }


    @GetMapping("/{id}")
    public Articolo articoloRichiestoDaUtente (@PathVariable int id) {
        return dao.articoloRichiesto(id);
    }

    @DeleteMapping("/{id}")
    public void cancellaArticoloRichiesto (@PathVariable int id) {
        dao.rimuoviArticolo(id);
    }



    @GetMapping("/{somma}")
    public String somma (@PathVariable int id1,@PathVariable int id2) {

      Articolo artUno = dao.richiedoArticoliSuCuiOperare(id1,id2).get(0);
      Articolo artDue = dao.richiedoArticoliSuCuiOperare(id1,id2).get(1);

      int p =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() + artDue.ArticoloToPence()).get("pound");
        int pe = gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() + artDue.ArticoloToPence()).get("shilling");
        int s = gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() + artDue.ArticoloToPence()).get("pence");

        return p + "" + s + "" + pe ;




    }



    @GetMapping("/{sottrazione}")
    public String sottrazione (@PathVariable int id1,@PathVariable int id2) {

        Articolo artUno = dao.richiedoArticoliSuCuiOperare(id1,id2).get(0);
        Articolo artDue = dao.richiedoArticoliSuCuiOperare(id1,id2).get(1);

        int p =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() - artDue.ArticoloToPence()).get("pound");
        int pe = gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() - artDue.ArticoloToPence()).get("shilling");
        int s = gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() - artDue.ArticoloToPence()).get("pence");

        return p + "" + s + "" + pe;




    }





    @GetMapping("/{prodotto}")
    public String prodotto (@PathVariable int id1,@PathVariable int n) {

        Articolo artUno = dao.richiedoArticoliSuCuiOperarePerMoltiplicazione(id1);


        int p =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() * n).get("pound");
        int pe =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() * n).get("pence");
        int s =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() * n).get("shilling");


        return p + "" + s + "" + pe + "";
    }


    @GetMapping("/{divisione}")
    public String divisione (@PathVariable int id1,@PathVariable int n) {

        Articolo artUno = dao.richiedoArticoliSuCuiOperarePerMoltiplicazione(id1);


        int p =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() * n).get("pound");
        int pe =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() * n).get("pence");
        int s =  gestionaleOperazioni.scambioMonete(artUno.ArticoloToPence() * n).get("shilling");


        return p + "" + s + "" + pe + "";




    }






}






