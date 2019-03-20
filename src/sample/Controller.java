package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {
    int clicks = 0;
    Klient klient = new Klient();

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private CheckBox checkbox0;

    @FXML
    private Button edasi;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private Label keskmineTekst;

    @FXML
    private Button edasi2;

    @FXML
    private Button edasi3;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private CheckBox checkbox4;

    @FXML
    private CheckBox checkbox5;

    @FXML
    private CheckBox checkbox6;

    @FXML
    private CheckBox checkbox7;

    @FXML
    private CheckBox checkbox8;

    @FXML
    private CheckBox checkbox9;

    @FXML
    private CheckBox checkbox10;

    @FXML
    private CheckBox checkbox11;

    @FXML
    private CheckBox checkbox12;

    @FXML
    private CheckBox checkbox13;

    @FXML
    private CheckBox checkbox14;

    List<CheckBox> checkboxList = new ArrayList<CheckBox>();



    @FXML
    void mineEdasi(ActionEvent event) throws Exception{
        AndmeteSaamine andmed = new AndmeteSaamine("https://dashboard.elering.ee/api/nps/price/ee/latest");


        if(clicks == 0) {
            keskmineTekst.setText("Where are you from?");
            keskmineTekst.setFont(new Font(20));
            edasi3.setVisible(true);
            edasi2.setVisible(true);
            edasi.setText("Eesti");


            progressBar.setProgress(0.2);
            checkboxList.addAll(Arrays.asList(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9,checkbox10,checkbox11,checkbox12,checkbox13,checkbox14));

        }
        else if (clicks == 1){
            keskmineTekst.setText("Which kind of user are you?");
            edasi3.setText("Light");
            edasi2.setText("Heavy");
            edasi.setText("Regular");
            progressBar.setProgress(0.4);

        }
        else if (clicks == 2){
            keskmineTekst.setText("Select your appliances");
            edasi2.setVisible(false);
            edasi3.setVisible(false);
            edasi.setText("Next");
            visibleCheckbox(checkboxList);
            scrollPane.setVisible(true);
            progressBar.setProgress(0.6);
        }
        else if (clicks == 3){
            keskmineTekst.setText("Loading");
            edasi.setText("Next");
            notVisibleCheckbox(checkboxList);
            scrollPane.setVisible(false);
            progressBar.setProgress(0.8);
            List<Integer> valitud =  ifCheckTrueInList(checkboxList);
            klient.setPaevaKulutus(valitud);


            keskmineTekst.setText("Electricity price right now: " + andmed.uuendaHind("https://dashboard.elering.ee/api/nps/price/ee/latest"));
            progressBar.setProgress(1);
        }
        else if (clicks == 4){
            keskmineTekst.setText("Price based on your usage: " + klient.kuuElektriTarbimine(andmed.getHindMWH()));
        }

        System.out.println("vajutus"+clicks);
        clicks += 1;
    }

    @FXML
    void f1f2f6(ActionEvent event) {

    }

    void visibleCheckbox(List<CheckBox> visible){
        for (int i = 0; i < visible.size(); i++) {
            visible.get(i).setVisible(true);
        }
    }

    void notVisibleCheckbox(List<CheckBox> visible){

        for (int i = 0; i < visible.size(); i++) {
            visible.get(i).setVisible(false);

        }
    }

    List<Integer> ifCheckTrueInList(List<CheckBox> list){
        List<Integer> valitud =new  ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).isSelected()){
                System.out.println("No vabsjee");
                valitud.add(i);
            }

        }
        return valitud;
    }

}
