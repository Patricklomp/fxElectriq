package sample;

public class Elektroonika {

    private String nimi;
    private double tarbimineTunnis;
    private double kasutusPaevas;
    //wattid
    private double tarbimineKuus;


    public Elektroonika(String nimi, double tarbimineTunnis, double kasutusPaevas) {
        this.nimi = nimi;
        this.tarbimineTunnis = tarbimineTunnis;
        this.kasutusPaevas = kasutusPaevas;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getTarbimineTunnis() {
        return tarbimineTunnis;
    }

    public void setTarbimineTunnis(double tarbimineTunnis) {
        this.tarbimineTunnis = tarbimineTunnis;
    }

    public double getKasutusPaevas() {
        return kasutusPaevas;
    }

    public void setKasutusPaevas(double kasutusPaevas) {
        this.kasutusPaevas = kasutusPaevas;
    }

    @Override
    public String toString() {
        return nimi+"("+tarbimineTunnis+"kWH)";
    }
}
