package sample;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Klient {
    private double tarbimisKonf = 1;
    double kuuTarbimine;
    double paevaTarbimine = 0;


    public double kuuElektriTarbimine(double hind) {

        System.out.println(hind);



        //Kuu Kohta
        double kuuTarbimine = paevaTarbimine*30;

        this.kuuTarbimine = kuuTarbimine;
        return kuuTarbimine;


    }



    public double  setPaevaKulutus(List<Integer> list){
        paevaTarbimine = 0;
        ///https://www.saveonenergy.com/energy-consumption/
        ArrayList<Elektroonika> vahendid = new ArrayList<Elektroonika>();


        Elektroonika kohviMasin = new Elektroonika("Coffee Maker",1050,0.4);
        Elektroonika microwawe = new Elektroonika("Microwave",925,0.1);
        Elektroonika toaster = new Elektroonika("Toaster",1100,0.1);
        Elektroonika dishwasher = new Elektroonika("Dishwasher",1800,1.0);
        Elektroonika washer = new Elektroonika("Washer",425,1.5);
        Elektroonika dryer = new Elektroonika("Dryer", 2600,1.0);
        Elektroonika iron = new Elektroonika("Iron",1000,0.5);
        Elektroonika fan = new Elektroonika("Ceiling fan",100,0.5);
        Elektroonika spaceHeater = new Elektroonika("Space heater (40gal)",1000,0.5);
        Elektroonika hairDryer = new Elektroonika("Hair dryer",1500,0.3);
        Elektroonika laptop = new Elektroonika("Laptop",50,1.5);
        Elektroonika monitor = new Elektroonika("Monitor",150,2.0);
        Elektroonika towerPC = new Elektroonika("PC",120,2.0);
        Elektroonika televisionSm = new Elektroonika("Television 19\"-36\"",100,2.0);
        Elektroonika televisionBg = new Elektroonika("Television 53\"-61\"",170,2.0);

        vahendid.addAll(Arrays.asList(kohviMasin,microwawe,toaster,dishwasher,washer,
                dryer,iron,fan,spaceHeater,hairDryer,laptop,monitor,towerPC,televisionSm,televisionBg));




        for (int i = 0; i < list.size(); i++) {
           Elektroonika vahend =  vahendid.get(list.get(i));

           paevaTarbimine += Math.round((vahend.getTarbimineTunnis() / 10000 * vahend.getKasutusPaevas())*100) / 100.0;
           // käibemaks + seadme keskmine energiatarbimine korrutatud tavalise kasutusajaga + teisendus MW peale

        }

        int muudKulud = 2;
        return paevaTarbimine * 1.2+muudKulud;
    }


}
