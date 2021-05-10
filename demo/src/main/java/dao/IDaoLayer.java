package dao;

import model.Articolo;

import java.util.List;

public interface IDaoLayer {

    List<Articolo> listaArticoli ();


        Articolo articoloRichiesto (int id);


        void inserisciArticolo (Articolo a);

        void modificaArticolo (int id);

        void rimuoviArticolo (int id);

    public List<Articolo> richiedoArticoliSuCuiOperare (int id1,int id2);


    public Articolo richiedoArticoliSuCuiOperarePerMoltiplicazione (int id1);


}
