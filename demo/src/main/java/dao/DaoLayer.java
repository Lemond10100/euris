package dao;

import model.Articolo;
import model.GestionaleOperazioni;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import util.BasicDao;
import util.IMappable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DaoLayer extends BasicDao implements IDaoLayer{

  GestionaleOperazioni go = new GestionaleOperazioni();




    public DaoLayer(@Value("${db.address}") String dbAddress, @Value("${db.user}") String user, @Value("${db.password}") String password){
        super(dbAddress,user,password);
    }



    public List<Articolo> richiedoArticoliSuCuiOperare (int id1,int id2) {
        List<Articolo> articoliSuCuiOperare = new ArrayList<>();

        String query1 = "select * from catalogo where id=?";
        String query2 = "select * from catalogo where id=?";

        Map<String,String> articoloUno = getOne(query1,id1);
        Map<String,String> articoloDue = getOne(query2,id2);

        articoliSuCuiOperare.add(IMappable.fromMap(Articolo.class,articoloUno));
        articoliSuCuiOperare.add(IMappable.fromMap(Articolo.class,articoloDue));

       return articoliSuCuiOperare;
    }



    public Articolo richiedoArticoliSuCuiOperarePerMoltiplicazione (int id1) {
      Articolo articoliSuCuiOperare = new Articolo();

        String query1 = "select * from catalogo where id=?";


        Map<String,String> articoloUno = getOne(query1,id1);


        articoliSuCuiOperare = IMappable.fromMap(Articolo.class,articoloUno);


        return articoliSuCuiOperare;
    }



    @Override
    public List<Articolo> listaArticoli() {
       List<Articolo> listaArticoli = new ArrayList<>();
       Articolo a = new Articolo();
       String query = "select * from catalogo";
       List<Map<String,String>> maps = getAll(query);

       for(Map<String,String> map : maps) {
           listaArticoli.add(IMappable.fromMap(Articolo.class,map));
       }
       return listaArticoli;
    }



    @Override
    public Articolo articoloRichiesto(int id) {
        Articolo a = null;
        String query = "select * from catalogo where id=?";
        Map<String,String> map = getOne(query,id);
        if(map != null) {
          return a = IMappable.fromMap(Articolo.class,map);
        }
        return null;
    }

    @Override
    public void inserisciArticolo(Articolo a) {
        String query = "insert into catalogo (nome,s,po,pe) values (?,?,?,?)";
        execute(query,a.getNome(),a.getSchelling(),a.getPound(),a.getPence());
    }

    @Override
    public void modificaArticolo(int id) {
        String query = "update catalogo set nome=?,s=?,po=?,pe=? where id=? ";
        execute(query,id);
    }

    @Override
    public void rimuoviArticolo(int id) {
        String query = "delete * from catalogo where id=?";
        execute(query,id);
    }
}
