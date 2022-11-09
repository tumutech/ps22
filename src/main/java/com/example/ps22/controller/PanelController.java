package com.example.ps22.controller;

import com.example.ps22.Main;
import com.example.ps22.model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class PanelController implements Initializable {
    public static TableView<Product> table_info_app,table_info_app2;
    public static TableView<stockmovt> stock_table;
    public static TableView<stockmovt> stock_table1;
    public static ObservableList<Product> data_table,data_table2,data_table3;
    public static ObservableList<white> stock_data;
    public static ObservableList<expenses> expensesdata;
    public static ObservableList<stockmovt>stock_data2;
    public static ObservableList<lpg> stock_data1;
    public static ObservableList<debitors> debitorslist;
    public static ObservableList<creditors> creditorslist;
    private static final DecimalFormat df = new DecimalFormat("0.0");
    private static final DecimalFormat currency = new DecimalFormat("#,###");
    @FXML
    private TableView<Product> fscr,fscr1,fscr11;
    @FXML
    private TableView<white> stock;
    @FXML TableView<expenses> expense;
    @FXML
    private TableView<debitors> debitors;
    @FXML
    private PasswordField password;
    @FXML
    private TableView<creditors> creditors;
    @FXML
    private TableColumn<debitors,String> clientname,amountgiven,paidamount,cbalance;
    @FXML TableColumn<creditors,String> dname, damount, dpaid, dbalance;
    @FXML
    private TableColumn<expenses, String> expensen,ecostp;
    @FXML
    private DatePicker fromdate,eddt;
    @FXML TableView<stockmovt> stock2;
    @FXML TableView<lpg> stock1;
    @FXML TableColumn<stockmovt,String> PNAME,SELLING,ospms,PK,QRC,PC,TSTOCK,cs,SLT,UN,gm,vosc,tov,los,stockpa,wqr,wtt,wcs,wsales,wpurchase,wun,wgm,wvos,wto,wlos,wsp;
    @FXML
    private TableColumn<lpg,String> PNAME1,SELLING1,ospms1,LPDT,lqr,ltt,lcs,lpsales,lpgpurchase,lpun,lpgm,lpvos,lpto,lpost,purchasestock;
    @FXML
    private TableColumn<stockmovt,String> LSELLING1,Lospms1;
    @FXML
    private TableColumn<Product, String> pdtr,cmrr,omrr,ptr,rttr,salesr,omrr1;
    @FXML
    private TableColumn<Product, String> pdtr1,cmrr1,omrr12,ptr1,rttr1,salesr1,omrr11;
    @FXML
    private TableColumn<Product, String> pdtr11,cmrr11,omrr121,ptr11,rttr11,salesr11,omrr111;
    @FXML
    private TableColumn<Product, Button> osr,osr1,osr11;
    @FXML
    private Button refreshb,refresh1,refresh11,addlub,RNP,addd,addcredit,savelpg,updatewhite,fuelstock,incomelpg,logout,exitapp;
    @FXML
    private TextField totalpms, totalago,totalbik,pmsopeningstock,pnamedit,pkedit,osedit,sedit,QR,pcedit,csedit,calr,agor,bikr,punit,aunit,bunit,ptotal,atotal,btotal,clname,ag,amapaid,debitotal,pmsdeliveries,physicalstock,agoopeningstock,agodeliveries,physicalago;
    @FXML TextField dcname,dcamount,dcpaid,cretotal,editexpense,editeamount,totalexpenses;
    @FXML
    private TextField bikopeningstock,bikdeliveries,physicalbik,totalwhiteproducts,lubuturn,totalgross,percy,lpgturn,lpggross,percy1,totalinco;
    @FXML
    private Tab Tab1;
    @FXML
    private TextField rtotalincome,rtotalexpense,rcashflow,availableassets,recoverableassets,totalliabilities,pbc,pr,gp;
    @FXML
    private BarChart<String,Number> barChart;
    @FXML
    private PieChart pieChart;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_info_app=fscr;
        stock_data =FXCollections.observableArrayList();
        stock_data2= FXCollections.observableArrayList();
        debitorslist= FXCollections.observableArrayList();
        creditorslist = FXCollections.observableArrayList();
        expensesdata = FXCollections.observableArrayList();
        initexpenses();
        initstock();
        initstock1();
        loadstock1();
        initializeCols();
        loadData();
        editableCols();
        initlubricants();
        editlubricants();
        initdebitors();
        initcreditors();
        editstock();
        editstock1();
        editbik();
        initsupdates();
        gp.setText(null);


//        pieChart.setTitle("ANALYSIS OF ASSETS AND LIABILITIES");
//        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
//        PieChart.Data slice2 = new PieChart.Data("Phone"  , 67);
//        PieChart.Data slice3 = new PieChart.Data("Tablet" , 36);
//
//        pieChart.getData().add(slice1);
//        pieChart.getData().add(slice2);
//        pieChart.getData().add(slice3);
//
//        barChart.setTitle("NET SITUATION ANALYSIS");
//        CategoryAxis xAxis    = new CategoryAxis();
//        xAxis.setLabel("Devices");
//
//        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Visits");
//
//        XYChart.Series dataSeries1 = new XYChart.Series();
//        dataSeries1.setName("2014");
//
//        dataSeries1.getData().add(new XYChart.Data("Desktop", 567));
//        dataSeries1.getData().add(new XYChart.Data("Phone"  , 65));
//        dataSeries1.getData().add(new XYChart.Data("Tablet"  , 23));
//
//        barChart.getData().add(dataSeries1);
        //Defining the axes
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>
                observableArrayList(Arrays.asList( "white products", "lubricants", "lpg")));
        xAxis.setLabel("category");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Gross margin");

        barChart.setTitle("Comparison between various products");

    }
    private void initializeCols(){
        // Product.java ==>>  pdt,cmr,omr,pt,rtt,sales,os
        pdtr.setCellValueFactory(new PropertyValueFactory<>("pdt"));
        cmrr.setCellValueFactory(new PropertyValueFactory<>("cmr"));
        omrr.setCellValueFactory(new PropertyValueFactory<>("omr"));
        omrr1.setCellValueFactory(new PropertyValueFactory<>("omr1"));
        ptr.setCellValueFactory(new PropertyValueFactory<>("pt"));
        rttr.setCellValueFactory(new PropertyValueFactory<>("rtt"));
        salesr.setCellValueFactory(new PropertyValueFactory<>("sales"));
        // for ago
        initicols(pdtr1,"pdt");
        initicols(cmrr1,"cmr");
        initicols(omrr12,"omr");
        initicols(ptr1,"pt");
        initicols(rttr1,"rtt");
        initicols(salesr1,"sales");
        //for bik
        initicols(pdtr11,"pdt");
        initicols(cmrr11,"cmr");
        initicols(omrr121,"omr");
        initicols(ptr11,"pt");
        initicols(rttr11,"rtt");
        initicols(salesr11,"sales");

    }
    public void Tabsync(ActionEvent actionEvente){
        Tab1.setOnSelectionChanged(ev -> {
            System.out.println(Tab1.isSelected() ? "Tab1 is selected" : "Tab1 is not selected" );
        });
    }
//    Tab1.setOnSelectionChanged(e -> {
//        System.out.println(Tab1.isSelected() ? "Tab1 is selected" : "Tab1 is not selected" );
//    });

    private void loadData(){
        data_table= FXCollections.observableArrayList();
            /* Generates the data items in the table */
            data_table.add(new Product("PMS 1","0","0", "0","Edit",new Button("SAVE")));
        data_table.add(new Product("PMS 2","0","0", "0","Edit",new Button("SAVE")));
        data_table.add(new Product("PMS 3","0","0", "0","Edit",new Button("SAVE")));
        data_table.add(new Product("PMS 4","0","0", "0","Edit",new Button("SAVE")));
        fscr.setItems(data_table);
        //for ago
        data_table2= FXCollections.observableArrayList();
        data_table2.add(new Product("AGO 1","0","0", "0","Edit",new Button("SAVE")));
        data_table2.add(new Product("AGO 2","0","0", "0","Edit",new Button("SAVE")));
        data_table2.add(new Product("AGO 3","0","0", "0","Edit",new Button("SAVE")));
        data_table2.add(new Product("AGO 4","0","0", "0","Edit",new Button("SAVE")));
        fscr1.setItems(data_table2);
        //for bik
        data_table3= FXCollections.observableArrayList();
        data_table3.add(new Product("BIK 1","0","0", "0","Edit",new Button("SAVE")));
        data_table3.add(new Product("BIK 2","0","0", "0","Edit",new Button("SAVE")));
        fscr11.setItems(data_table3);
    }
    private void editableCols(){
//        pdtr.setCellFactory(TextFieldTableCell.forTableColumn());
//        pdtr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPdt(e.getNewValue()));
        cmrr.setCellFactory(TextFieldTableCell.forTableColumn());
        cmrr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setCmr(e.getNewValue()));
        omrr.setCellFactory(TextFieldTableCell.forTableColumn());
        omrr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOmr(e.getNewValue()));
        omrr1.setCellFactory(TextFieldTableCell.forTableColumn());
        omrr1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOmr1(e.getNewValue()));
       //ptr.setCellFactory(TextFieldTableCell.forTableColumn());
       //ptr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPt(e.getNewValue()));
        rttr.setCellFactory(TextFieldTableCell.forTableColumn());
        rttr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setRtt(e.getNewValue()));

        //for ago.
        cmrr1.setCellFactory(TextFieldTableCell.forTableColumn());
        cmrr1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setCmr(e.getNewValue()));
        omrr12.setCellFactory(TextFieldTableCell.forTableColumn());
        omrr12.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOmr(e.getNewValue()));
        omrr11.setCellFactory(TextFieldTableCell.forTableColumn());
        omrr11.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOmr1(e.getNewValue()));
        //ptr.setCellFactory(TextFieldTableCell.forTableColumn());
        //ptr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPt(e.getNewValue()));
        rttr1.setCellFactory(TextFieldTableCell.forTableColumn());
        rttr1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setRtt(e.getNewValue()));

        /* Allow for the values in each cell to be changable */

        fscr.setEditable(true);
        fscr1.setEditable(true);
    }
    public void refresh(ActionEvent event) {
            fscr.refresh();
            fscr1.refresh();
        totalpms.setText(calculatetotals(salesr, fscr));
        calr.setText(calculatetotals(salesr, fscr));
    }

    public void refresh2(ActionEvent e){
        fscr.refresh();
        fscr1.refresh();
        totalago.setText(calculatetotals(salesr1,fscr1));
        agor.setText(calculatetotals(salesr1,fscr1));
        bikr.setText(calculatetotals(salesr11,fscr11));
        //refresh(ActionEvent e);
    }
    public void doout() throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("LOG OUT");
        alert.setContentText("Exit Application");
        String s = "Are you sure you want to log out";
        alert.setContentText(s);

        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Parent root = FXMLLoader.load(Main.class.getResource("Login.fxml"));
            Stage window = (Stage) logout.getScene().getWindow();
            window.setScene(new Scene(root));
        }


    }
    public void refresh3(ActionEvent e){
        fscr11.refresh();
        totalbik.setText(calculatetotals(salesr11,fscr11));
        bikr.setText(calculatetotals(salesr11,fscr11));
    }
    public void refreshwhite(ActionEvent e){
        stock.refresh();
    }
    //for intialising columns
    public void initicols(TableColumn<Product,String> colname,String colword){
        colname.setCellValueFactory(new PropertyValueFactory<>(colword));
    }
    public void repoprint(ActionEvent e){
            if(gp.getText() != null) {
                String date = fromdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String enddate = eddt.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                reports ppp = new reports(calr.getText(),punit.getText(),ptotal.getText(),agor.getText(),aunit.getText(),atotal.getText(),bikr.getText(),bunit.getText(),btotal.getText(),totalwhiteproducts.getText(),lubuturn.getText(),percy.getText(),totalgross.getText(),lpgturn.getText(),
                        percy1.getText(),lpggross.getText(),cretotal.getText(),debitotal.getText(),totalinco.getText(),totalexpenses.getText(),rcashflow.getText(),availableassets.getText(),recoverableassets.getText(),totalliabilities.getText(),pbc.getText(),pr.getText(),gp.getText(),date,enddate);

                ppp.printreport();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Report Print");
                alert.setHeaderText(null);
                alert.setContentText("Report generated  successfully!\n");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Report could not be generated, some data is missing in the audit\n" + "" +
                        "Fill blank fields and try again");
                alert.showAndWait();

            }
    }
//    public void editcol(TableColumn<Product,String> editablecol){
//        editablecol.setCellFactory(TextFieldTableCell.forTableColumn());
//        editablecol.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setRtt(e.getNewValue()));
//    }
    //getting total of a column
    public String calculatetotals(TableColumn<Product, String> mycolumn,TableView<Product> mytable){
        int mytotal = 0;
        List<String> columnData1 = new ArrayList<>();
        for (Product item : mytable.getItems()) {
            columnData1.add(mycolumn.getCellObservableValue(item).getValue());
        }
        for (String columnDatum : columnData1) {
            mytotal = mytotal + Integer.parseInt(columnDatum);
        }
        return String.valueOf(mytotal);

    }
    public void offnow(ActionEvent poweroff){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Real Auditor");
        alert.setHeaderText("You will lose unsaved changes, are you sure to exit now?");
        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Platform.exit();
        }

    }
    public String calexpenses(){
        int texpense = 0;
        List<String> coldata = new ArrayList<>();
        for(expenses item : expense.getItems()){
            coldata.add(ecostp.getCellObservableValue(item).getValue());
        }
        for (String cold:coldata){
            texpense = texpense + Integer.parseInt(cold);
        }
        return String.valueOf(texpense);
    }
    public String calturn(TableColumn<stockmovt,String>mycolumn,TableView<stockmovt>myt){
        int tturno = 0;
        List<String> turli = new ArrayList<>();
        for(stockmovt item : myt.getItems()){
            turli.add(mycolumn.getCellObservableValue(item).getValue());
        }
        for(String toto:turli){
            tturno = tturno + Integer.parseInt(toto);
        }
        return String.valueOf(tturno);

    }
    public void loadincome(ActionEvent e){
        lpgturn.setText(totlgp(lpto,stock1));
        lpggross.setText(totlgp(lpgm,stock1));
        float a = Integer.parseInt(totlgp(lpto,stock1));
        float b = Integer.parseInt(totlgp(lpgm,stock1));
        float c= (b/a)*100;
        percy1.setText(df.format(c) +"%");
    }
    public void gettotalincome(ActionEvent e){
        int totalincomecollected = Integer.parseInt(ptotal.getText())+Integer.parseInt(atotal.getText())+Integer.parseInt(btotal.getText())+Integer.parseInt(totalgross.getText())+Integer.parseInt(lpggross.getText());
        totalinco.setText(String.valueOf((totalincomecollected)));
        loadgraph();

    }
    public void loadresults(ActionEvent e){
        rtotalincome.setText(totalinco.getText());
        availableassets.setText(totalinco.getText());
        recoverableassets.setText(String.valueOf(Integer.parseInt(totalinco.getText())+Integer.parseInt(debitotal.getText())));
        rtotalexpense.setText(totalexpenses.getText());
        rcashflow.setText(String.valueOf(Integer.parseInt(totalinco.getText())-Integer.parseInt(totalexpenses.getText())));

    }
    public String totlgp(TableColumn<lpg,String>mycolumn,TableView<lpg>myt){
        int tturno = 0;
        List<String> turli = new ArrayList<>();
        for(lpg item : myt.getItems()){
            turli.add(mycolumn.getCellObservableValue(item).getValue());
        }
        for(String toto:turli){
            tturno = tturno + Integer.parseInt(toto);
        }
        return String.valueOf(tturno);

    }

    public String totaldebitors(TableColumn<debitors, String> mycolumn,TableView<debitors> mytable){
        int debitorstotal = 0;
        List<String> columdata = new ArrayList<>();
        for (debitors item: mytable.getItems()){
            columdata.add(mycolumn.getCellObservableValue(item).getValue());
        }
        for (String coluda : columdata){
            debitorstotal = debitorstotal + Integer.parseInt(coluda);
        }
        return String.valueOf(debitorstotal);

    };
    public String totalcreditors(TableColumn<creditors, String> mycolumn, TableView<creditors> mytable){
        int creditorstotal = 0;
        List<String> coldata = new ArrayList<>();
        for(creditors item: mytable.getItems()){
            coldata.add(mycolumn.getCellObservableValue(item).getValue());
        }
        for (String colda: coldata){
            creditorstotal = creditorstotal + Integer.parseInt(colda);
        }
        return String.valueOf(creditorstotal);
    }
    public void initstock(){
        PNAME.setCellValueFactory(new PropertyValueFactory<>("pdtn"));
        SELLING.setCellValueFactory(new PropertyValueFactory<>("selling"));
        ospms.setCellValueFactory(new PropertyValueFactory<>("openstock"));
        wqr.setCellValueFactory(new PropertyValueFactory<>("qr"));
        wtt.setCellValueFactory(new PropertyValueFactory<>("tstock"));
        wcs.setCellValueFactory(new PropertyValueFactory<>("clostock"));
        wsales.setCellValueFactory(new PropertyValueFactory<>("saleslt"));
        wpurchase.setCellValueFactory(new PropertyValueFactory<>("purchase"));
        wun.setCellValueFactory(new PropertyValueFactory<>("unitmargin"));
        wgm.setCellValueFactory(new PropertyValueFactory<>("grossmargin"));
        wvos.setCellValueFactory(new PropertyValueFactory<>("valueofstock"));
        wto.setCellValueFactory(new PropertyValueFactory<>("turnover"));
        wlos.setCellValueFactory(new PropertyValueFactory<>("lopeningstock"));
        wsp.setCellValueFactory(new PropertyValueFactory<>("pstock"));
    }
    public void initexpenses(){
        expensen.setCellValueFactory(new PropertyValueFactory<>("expensename"));
        ecostp.setCellValueFactory(new PropertyValueFactory<>("ecost"));
    }
    public void initstock1(){
        PNAME1.setCellValueFactory(new PropertyValueFactory<>("pdtn"));
        SELLING1.setCellValueFactory(new PropertyValueFactory<>("selling"));
        ospms1.setCellValueFactory(new PropertyValueFactory<>("openstock"));
        lqr.setCellValueFactory(new PropertyValueFactory<>("qr"));
        ltt.setCellValueFactory(new PropertyValueFactory<>("tstock"));
        lcs.setCellValueFactory(new PropertyValueFactory<>("clostock"));
        lpsales.setCellValueFactory(new PropertyValueFactory<>("saleslt"));
        lpgpurchase.setCellValueFactory(new PropertyValueFactory<>("purchase"));
        lpun.setCellValueFactory(new PropertyValueFactory<>("unitmargin"));
        lpgm.setCellValueFactory(new PropertyValueFactory<>("grossmargin"));
        lpvos.setCellValueFactory(new PropertyValueFactory<>("valueofstock"));
        lpto.setCellValueFactory(new PropertyValueFactory<>("turnover"));
        lpost.setCellValueFactory(new PropertyValueFactory<>("lopeningstock"));
        purchasestock.setCellValueFactory(new PropertyValueFactory<>("pstock"));

    }
    public void initlubricants(){
        LPDT.setCellValueFactory(new PropertyValueFactory<>("pdtn"));
        PK.setCellValueFactory(new PropertyValueFactory<>("pk"));
        LSELLING1.setCellValueFactory(new PropertyValueFactory<>("selling"));
        Lospms1.setCellValueFactory(new PropertyValueFactory<>("openstock"));
        QRC.setCellValueFactory(new PropertyValueFactory<>("qr"));
        PC.setCellValueFactory(new PropertyValueFactory<>("purchase"));
        TSTOCK.setCellValueFactory(new PropertyValueFactory<>("tstock"));
        cs.setCellValueFactory(new PropertyValueFactory<>("clostock"));
        SLT.setCellValueFactory(new PropertyValueFactory<>("saleslt"));
        UN.setCellValueFactory(new PropertyValueFactory<>("unitmargin"));
        gm.setCellValueFactory(new PropertyValueFactory<>("grossmargin"));
        vosc.setCellValueFactory(new PropertyValueFactory<>("valueofstock"));
        tov.setCellValueFactory(new PropertyValueFactory<>("turnover"));
        los.setCellValueFactory(new PropertyValueFactory<>("lopeningstock"));
        stockpa.setCellValueFactory(new PropertyValueFactory<>("pstock"));

    }
    public void initdebitors(){
        clientname.setCellValueFactory(new PropertyValueFactory<>("cname"));
        amountgiven.setCellValueFactory(new PropertyValueFactory<>("acredited"));
        paidamount.setCellValueFactory(new PropertyValueFactory<>("cpaid"));
        cbalance.setCellValueFactory(new PropertyValueFactory<>("balance"));


    }
    public void initcreditors(){
        dname.setCellValueFactory(new PropertyValueFactory<>("cname"));
        damount.setCellValueFactory(new PropertyValueFactory<>("acredited"));
        dpaid.setCellValueFactory(new PropertyValueFactory<>("cpaid"));
        dbalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
    }
    public void loadstock(){
        stock_data= FXCollections.observableArrayList();
        stock_data.add(new white("PMS","1000",pmsopeningstock.getText(),"none",pmsdeliveries.getText(),"500",physicalstock.getText()));
        stock_data.add(new white("AGO","0",agoopeningstock.getText(),"none",agodeliveries.getText(),"0",physicalago.getText()));
        stock_data.add(new white("BIK","0",bikopeningstock.getText(),"none",bikdeliveries.getText(),"0",physicalbik.getText()));
        stock.setItems(stock_data);
    }
    public void loadstock1(){
        stock_data1= FXCollections.observableArrayList();
        stock_data1.add(new lpg("6KG CYLINDERS","0","0","gggg","0","0","0"));
        stock_data1.add(new lpg("12.5KG CYLINDERS","0","0","gggg","0","0","0"));
        stock_data1.add(new lpg("38KG CYLINDERS","0","0","gggg","0","0","0"));
        stock1.setItems(stock_data1);

    }
    public void addlubricant(ActionEvent e){
        stock_data2.add(new stockmovt(pnamedit.getText(),sedit.getText(),osedit.getText(),pkedit.getText(),QR.getText(),pcedit.getText(),csedit.getText()));
        stock2.setItems(stock_data2);

    }
    public void addexpense(ActionEvent e){
        expensesdata.add(new expenses(editexpense.getText(),editeamount.getText()));
        expense.setItems(expensesdata);
        totalexpenses.setText(calexpenses());
    }
    public void adddebitors(ActionEvent e){
        debitorslist.add(new debitors(clname.getText(),ag.getText(),amapaid.getText()));
        debitors.setItems(debitorslist);
        debitotal.setText(totaldebitors(cbalance,debitors));

    }
    public void addcreditors(ActionEvent e){
        creditorslist.add(new creditors(dcname.getText(),dcamount.getText(),dcpaid.getText()));
        creditors.setItems(creditorslist);
        cretotal.setText(totalcreditors(dbalance,creditors));
    }
    public void editlubricants(){
        LPDT.setCellFactory(TextFieldTableCell.forTableColumn());
        LPDT.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPdtn(e.getNewValue()));
        PK.setCellFactory(TextFieldTableCell.forTableColumn());
        PK.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPk(e.getNewValue()));
        LSELLING1.setCellFactory(TextFieldTableCell.forTableColumn());
        LSELLING1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setSelling(e.getNewValue()));
        Lospms1.setCellFactory(TextFieldTableCell.forTableColumn());
        Lospms1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOpenstock(e.getNewValue()));
        QRC.setCellFactory(TextFieldTableCell.forTableColumn());
        QRC.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setQr(e.getNewValue()));
        PC.setCellFactory(TextFieldTableCell.forTableColumn());
        PC.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPurchase(e.getNewValue()));
        stock2.setEditable(true);
        stock2.refresh();
    }
    public void editstock1(){
        ospms1.setCellFactory(TextFieldTableCell.forTableColumn());
        ospms1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOpenstock(e.getNewValue()));
        lqr.setCellFactory(TextFieldTableCell.forTableColumn());
        lqr.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setQr(e.getNewValue()));
        lcs.setCellFactory(TextFieldTableCell.forTableColumn());
        lcs.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setClostock(e.getNewValue()));
        SELLING1.setCellFactory(TextFieldTableCell.forTableColumn());
        SELLING1.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setSelling(e.getNewValue()));
        lpgpurchase.setCellFactory(TextFieldTableCell.forTableColumn());
        lpgpurchase.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPurchase(e.getNewValue()));
        stock1.setEditable(true);
    }
    public void editbik(){
        cmrr11.setCellFactory(TextFieldTableCell.forTableColumn());
        cmrr11.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setCmr(e.getNewValue()));
        omrr121.setCellFactory(TextFieldTableCell.forTableColumn());
        omrr121.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setOmr(e.getNewValue()));
        rttr11.setCellFactory(TextFieldTableCell.forTableColumn());
        rttr11.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setRtt(e.getNewValue()));
        fscr11.setEditable(true);



    }
    public void loadturnover(ActionEvent e){
        stock2.refresh();
        lubuturn.setText(calturn(tov,stock2));
        totalgross.setText(calturn(gm,stock2));
        float a = Integer.parseInt(calturn(tov,stock2));
        float b = Integer.parseInt(calturn(gm,stock2));
        float c= (b/a)*100;
        percy.setText(String.valueOf(df.format(c))+"%");
    }
    public void initsupdates(){
        pmsopeningstock.setText("0");
        pmsdeliveries.setText("0");
        physicalstock.setText("0");
        agoopeningstock.setText("0");
        physicalago.setText("0");
        agodeliveries.setText("0");
        bikopeningstock.setText("0");
        bikdeliveries.setText("0");
        physicalbik.setText("0");
        }
        public void loadgraph(){

            //Prepare XYChart.Series objects by setting data
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            series1.setName("White Products");
            series1.getData().add(new XYChart.Data<>("PMS",Integer.parseInt(ptotal.getText())));
            series1.getData().add(new XYChart.Data<>("BIK", Integer.parseInt(atotal.getText())));
            series1.getData().add(new XYChart.Data<>("AGO",Integer.parseInt(btotal.getText())));

            XYChart.Series<String, Number> series2 = new XYChart.Series<>();
            series2.setName("Lubricants");
            series2.getData().add(new XYChart.Data<>("Lubricant",Integer.parseInt(totalgross.getText())));

            XYChart.Series<String, Number> series3 = new XYChart.Series<>();
            series3.setName("LPG");
            series3.getData().add(new XYChart.Data<>("LPG", Integer.parseInt(lpggross.getText())));
            //Setting the data to bar chart
            barChart.getData().addAll(series1, series2, series3);
        }
    public void editstock(){
        SELLING.setCellFactory(TextFieldTableCell.forTableColumn());
        SELLING.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setSelling(e.getNewValue()));
        wpurchase.setCellFactory(TextFieldTableCell.forTableColumn());
        wpurchase.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setPurchase(e.getNewValue()));
        stock.setEditable(true);
    }
    public void refreshlpg(ActionEvent e){
        stock1.refresh();

    }
    public void getliabilities(ActionEvent e){
        totalliabilities.setText(String.valueOf(Integer.parseInt(totalexpenses.getText())+Integer.parseInt(cretotal.getText())));
        pbc.setText(String.valueOf(Integer.parseInt(recoverableassets.getText())-Integer.parseInt(totalliabilities.getText())));
        pr.setText(String.valueOf(Integer.parseInt(availableassets.getText())-Integer.parseInt(totalliabilities.getText())));
        gp.setText(String.valueOf(Integer.parseInt(pbc.getText())-Integer.parseInt(pr.getText())));
    }
    public void updatefuelstock(ActionEvent e){
        loadstock();
    }
    public void getr(ActionEvent e){
        System.out.println("REFRESHING");
        calr.setText(calculatetotals(salesr,fscr));
        agor.setText(calculatetotals(salesr1,fscr1));
        bikr.setText(calculatetotals(salesr11,fscr11));
        ptotal.setText(String.valueOf(Integer.parseInt(punit.getText())*Integer.parseInt(calr.getText())));
        atotal.setText(String.valueOf(Integer.parseInt(aunit.getText())*Integer.parseInt(agor.getText())));
        btotal.setText(String.valueOf(Integer.parseInt(bunit.getText())*Integer.parseInt(bikr.getText())));
        totalwhiteproducts.setText(String.valueOf(Integer.parseInt(ptotal.getText())+Integer.parseInt(atotal.getText())+Integer.parseInt(btotal.getText())));
}
}