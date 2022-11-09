package com.example.ps22.model;

public class stockmovt {
    String pdtn,pk,selling,openstock,qr,purchase, tstock,saleslt,clostock,unitmargin,grossmargin,valueofstock,turnover,lopeningstock,pstock;
    public stockmovt(String productname, String sellingprice, String openstoc,String pk1,String qr1,String purchase1,String clostock){
        this.pdtn = productname;
        this.selling = sellingprice;
        this.openstock = openstoc;
        this.pk = pk1;
        this.qr = qr1;
        this.purchase = purchase1;
        this.clostock = clostock;
        //this.tstock = tsock;

    }
    public stockmovt(String productname, String sellingprice, String openstoc){
        this.pdtn = productname;
        this.selling = sellingprice;
        this.openstock = openstoc;
    }

    public stockmovt() {

    }

    //Product name
    public void setPdtn(String product){
        this.pdtn = product;
    }
    public String getPdtn(){
        return pdtn;
    }
    //Selling price
    public void setSelling(String sellingP){
        this.selling = sellingP;
    }
    public String getSelling(){
        return selling;
    }
    //opening stock
    public void setOpenstock(String opns){
        this.openstock = opns;
    }
    public String getOpenstock(){
        return openstock;
    }
    public void setPk(String pk1){
        this.pk = pk1;
    }
    public String getPk(){
        return pk;
    };
    public void setQr(String qr1){
        this.qr = qr1;
    }

    public String getQr() {
        return qr;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }
    public String getClostock(){
        return clostock;
    }

    public void setClostock(String clostock) {
        this.clostock = clostock;
    }

    public  String getTstock(){
        double opns = Double.parseDouble(openstock);
        double qrd = Double.parseDouble(qr);
        double tsk = opns + qrd;
        System.out.println(tsk);
        tstock = String.valueOf(tsk);
        return tstock;

    }
    public String getSaleslt(){
        double totalstock = Double.parseDouble(tstock);
        double closingstock = Double.parseDouble(clostock);
        double lts = totalstock - closingstock;
        this.saleslt = String.valueOf(lts);
        return saleslt;
    }

    public String getUnitmargin() {
        double pprice = Double.parseDouble(purchase);
        double slprice = Double.parseDouble(selling);
        double un = slprice -pprice;
        this.unitmargin = String.valueOf(un);
        return unitmargin;
    }
    public String getGrossmargin(){
        double lsales = Double.parseDouble(saleslt);
        double unargin = Integer.parseInt(unitmargin);
        double grm = lsales * unargin;
        this.grossmargin = String.valueOf(grm);
        return grossmargin;
    }
    //v.os purchase* closing stock

    public String getValueofstock() {
        double purprice =  Double.parseDouble(purchase);
        double closing  = Double.parseDouble(clostock);
        double vos = purprice * closing;
        this.valueofstock = String.valueOf(vos);
        return valueofstock;
    }
    //turn over sales*selling price
    public String getTurnover() {
        double sellp = Double.parseDouble(selling);
        double salesn = Double.parseDouble(saleslt);
        double tov = sellp*salesn;
        this.turnover = String.valueOf(tov);
        return turnover;
    }
    // opening stock = ops * purchase


    public String getLopeningstock() {
        double fos = Double.parseDouble(openstock);
        double purprice = Double.parseDouble(purchase);
        double los = fos*purprice;
        this.lopeningstock = String.valueOf(los);
        return lopeningstock;
    }

    public String getPstock() {
        double qre = Double.parseDouble(qr);
        double purchasep = Double.parseDouble(purchase);
        double pastock = qre*purchasep;
        this.pstock= String.valueOf(pastock);
        return pstock;
    }
}

