package com.example.ps22.model;

import javafx.scene.control.Button;
import com.example.ps22.controller.PanelController;
import javafx.collections.ObservableList;

public class Product {
    String pdt, rtt, sales,cmr,omr,pt,omr1;
    Button os;
    public Product(String ptd, String cmr, String omr,String rtt,String omr1, Button os){
        this.pdt =ptd;
        this.cmr =cmr;
        this.omr = omr;
        this.os = os;
        this.rtt = rtt;
        this.omr1 = omr1;
        //this.sales= sales;
        //this.osr5 = osr5;
        os.setOnAction(e->{
            /* Print the values of the row selected */
            ObservableList<Product> users= PanelController.table_info_app.getSelectionModel().getSelectedItems();

            /* It outputs the value in the terminal */
            for(Product user:users){
                if(user.getOs()== os){
                    System.out.println("ptd: "+user.getPdt());
                    System.out.println("cmr: "+user.getCmr());
                    System.out.println("omr: "+user.getOmr());
                    System.out.println("pt: "+user.getPt());
                    System.out.println("rtt: "+user.getRtt());
                    System.out.println("opening stock: "+user.getOmr1());
                }}
        });
    }
    /* Getters and setters */
    public String getPdt(){
        return pdt;
    }
    public void setPdt(String pdt){
        this.pdt = pdt;
    }
    public String getCmr(){
        return cmr;
    }
    public void setCmr(String cmr){
        this.cmr = cmr;
    }
    public String getOmr(){
        return omr;
    }
    public void setOmr(String omr){
        this.omr = omr;
    }
    public String getOmr1(){
        return omr1;
    }
    public void setOmr1(String omr1){
        this.omr1 = omr1;
    }
    public String getPt(){
        double a =Double.parseDouble(cmr);
        double b = Double.parseDouble(omr);
        double c = a-b;
        String pump = String.valueOf(c);
        System.out.println(c);
        return pump;
    }
    public void setPt(String pt){
        this.pt = cmr;
    }
    public String getRtt(){
        return rtt;
    }
    public void setRtt(String rtt){
        this.rtt = rtt;
    }
    public String getSales(){
        double c1 = Double.parseDouble(getPt());
        double e1 = c1 - Double.parseDouble(rtt);
        sales = String.valueOf(e1);
        return sales;
    }
    public void setSales(String sales){
        this.sales = sales;
    }
    public Button getOs(){
        return os;
    }

}
