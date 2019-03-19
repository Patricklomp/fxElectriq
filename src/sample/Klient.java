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


        Elektroonika kohviMasin = new Elektroonika("Coffee Maker",1000,0.5);
        Elektroonika mikrowawe = new Elektroonika("Microwave",800,0.5);
        Elektroonika toaster = new Elektroonika("Toaster",1000,0.5);
        Elektroonika dishwasher = new Elektroonika("Dishwasher",1000,0.5);
        Elektroonika washer = new Elektroonika("Washer",1000,0.5);
        Elektroonika dryer = new Elektroonika("Dryer",1000,0.5);
        Elektroonika iron = new Elektroonika("Iron",1000,0.5);
        Elektroonika fan = new Elektroonika("Ceiling fan",1000,0.5);
        Elektroonika spaceHeater = new Elektroonika("Space heater (40gal)",1000,0.5);
        Elektroonika laptop = new Elektroonika("Hair dryer",1000,0.5);
        Elektroonika monitor = new Elektroonika("Laptop",1000,0.5);
        Elektroonika towerPC = new Elektroonika("Monitor",1000,0.5);
        Elektroonika televisionSm = new Elektroonika("PC",1000,0.5);
        Elektroonika televisionBg = new Elektroonika("Coffee Maker",1000,0.5);

        vahendid.addAll(Arrays.asList(kohviMasin,mikrowawe,toaster,dishwasher,washer,
                dryer,iron,fan,spaceHeater,laptop,monitor,towerPC,televisionSm,televisionBg));




        for (int i = 0; i < list.size(); i++) {
           Elektroonika vahend =  vahendid.get(list.get(i));

           paevaTarbimine += vahend.getTarbimineTunnis()*vahend.getKasutusPaevas();


        }


        return paevaTarbimine;
    }


}
