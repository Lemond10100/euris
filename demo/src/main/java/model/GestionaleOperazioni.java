package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionaleOperazioni {


    public Map<String,Integer> scambioMonete (int totPence) {

        HashMap<String,Integer> mappaMonetaCifra = new HashMap<>();

        int pence = totPence%12;
        int shillingTemp = totPence/12;
        int shilling = shillingTemp%20;
        int pound = shillingTemp/20;


        mappaMonetaCifra.put("pound",pound);
        mappaMonetaCifra.put("shilling",shilling);
        mappaMonetaCifra.put("pence",pence);

        return mappaMonetaCifra;

    }




/*
    public String scambioMonete (String totPenceStringa) {




        String resultPound = "";
        String resultPence = "";
        String resultShilling = "";

        int totPence = Integer.parseInt(totPenceStringa);

        HashMap<String,Integer> mappaMonetaCifra = new HashMap<>();

        int pence = totPence%12;
        int shillingTemp = totPence/12;
        int shilling = shillingTemp%20;
        int pound = shillingTemp/20;


        mappaMonetaCifra.put("pound",pound);
        mappaMonetaCifra.put("shilling",shilling);
        mappaMonetaCifra.put("pence",pence);


        resultPound = "" + mappaMonetaCifra.get("pound");
        resultPence = "" + mappaMonetaCifra.get("pence");
        resultShilling = "" + mappaMonetaCifra.get("shilling");



    }

*/

}
