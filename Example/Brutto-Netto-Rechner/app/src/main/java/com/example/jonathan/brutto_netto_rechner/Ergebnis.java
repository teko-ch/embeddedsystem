package com.example.jonathan.brutto_netto_rechner;

/**
 * Created by jonathan on 05/07/16.
 */
public class Ergebnis {
    public float betrag;
    public boolean isNetto;
    public int mwstProzent;

    public float betragNetto;
    public float betragBrutto;
    public float betragMwst;


    public void berechneErgebnis(){
        if (isNetto){
            betragNetto = betrag;
            betragMwst = betrag * mwstProzent / 100;
            betragBrutto = betrag + betragMwst;
        }else {
            betragBrutto = betrag;
            betragMwst = betrag * mwstProzent / (100 + mwstProzent);
            betragNetto = betrag - betragMwst;
        }
    }
}
