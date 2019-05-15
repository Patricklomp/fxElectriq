package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {
    int clicks = 0;
    Klient klient = new Klient();

    @FXML
    private Label electriq;
    @FXML
    private CheckBox checkbox11;

    @FXML
    private CheckBox checkbox10;

    @FXML
    private CategoryAxis xAxis = new CategoryAxis();

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private CheckBox checkbox0;

    @FXML
    private CheckBox checkbox14;

    @FXML
    private Button edasi;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox13;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private CheckBox checkbox12;

    @FXML
    private Label keskmineTekst;

    @FXML
    private NumberAxis yAxis = new NumberAxis();

    @FXML
    private BarChart<String, Number> priceChart = new BarChart<String, Number>(xAxis,yAxis);

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

    List<CheckBox> checkboxList = new ArrayList<CheckBox>();




    @FXML
    protected void initialize(){
        electriq.setFont(new Font("Arbutus Slab",40));
        System.out.println("siin");
    }



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
            checkboxList.addAll(Arrays.asList(checkbox0,checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,
                    checkbox8,checkbox9,checkbox10,checkbox11,checkbox12,checkbox13,checkbox14));

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
            List<Integer> valitud =  ifCheckTrueInList(checkboxList);
            klient.setPaevaKulutus(valitud);


            keskmineTekst.setText("Electricity price at this hour: " + andmed.uuendaHind("https://dashboard.elering.ee/api/nps/price/ee/latest") + " eur/MWh");
            progressBar.setProgress(0.8);
        }
        else if (clicks == 4){
            priceChart.setVisible(true);
            double kliendiArve = Math.round(klient.kuuElektriTarbimine(andmed.getHindMWH()));


            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Avg Est");
            series1.getData().add(new XYChart.Data("", 35));

            XYChart.Series series2 = new XYChart.Series();
            series2.setName("User");
            series2.getData().add(new XYChart.Data("", kliendiArve));

            priceChart.getData().addAll(series1,series2);
            keskmineTekst.setText("Monthly price based on your usage (incl. VAT 20%): " + kliendiArve + " eur");
            progressBar.setProgress(1);
        }


        clicks += 1;
        if (clicks == 6){
            System.exit(0);
        }
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

                valitud.add(i);
            }

        }
        System.out.println(valitud.toString());
        return valitud;
    }

}
