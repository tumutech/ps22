package com.example.ps22.controller;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;


public class reports {
    String pmsq, pmsu,pmsg,agoq,agou,agog,bikq,biku,bikg,wtotal,lt,lr,lg,ltp,lrp,lgp,tcs,tds,ti,te,cf,aa,ra,tl,ee,rr,gg,fd,ld,CAD;
    public reports(String pmsquantity,String pmsunit, String pmsgross, String agoquantity,String agou, String agog,
                   String bikq,String biku, String bikg,String wtotal,
                   String lt,String lr,String lg,
                   String ltp,String lrp,String lgp,
                   String tcs, String tds, String ti, String te, String cf,
                   String aa, String ra, String tl, String ee, String  rr, String gg,
                   String fd,String ld){
        this.aa = aa;
        this.ra = ra;
        this.tl = tl;
        this.ee = ee;
        this.rr = rr;
        this.gg = gg;
        this.tcs = tcs;
        this.tds = tds;
        this.ti = ti;
        this.te = te;
        this.cf = cf;
        this.pmsq = pmsquantity;
        this.pmsu = pmsunit;
        this.pmsg = pmsgross;
        this.agoq = agoquantity;
        this.agou = agou;
        this.agog = agog;
        this.bikq = bikq;
        this.biku = biku;
        this.bikg = bikg;
        this.wtotal = wtotal;
        this.lt = lt;
        this.lr = lr;
        this.lg = lg;
        this.ltp = ltp;
        this.lrp = lrp;
        this.lgp = lgp;
        this.fd = fd;
        this.ld = ld;
    }

    public void printreport() {
        com.itextpdf.text.Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 10, new CMYKColor(255, 0, 0, 0));
        com.itextpdf.text.Font redFont = FontFactory.getFont(FontFactory.HELVETICA, 14, new CMYKColor(0, 255, 0, 0));
        com.itextpdf.text.Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14);
        Document document = new Document();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd_MMM_yyyy");
        Date CADATE = new Date();
        CAD = dateFormat.format(CADATE);
        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream(String.valueOf(CAD+".pdf")));
            document.open();
            System.out.println(CAD+".pdf created");

            PdfPTable table = new PdfPTable(3);
            PdfPTable products = new PdfPTable(4);
            PdfPTable otherp = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 4, 3});
            products.setWidths(new float[]{3, 2, 2, 2});

            Image image = Image.getInstance("rg.png");
            PdfPCell cell1 = new PdfPCell(image, true);
            cell1.setBorder(0);
            cell1.setFixedHeight(70);
            PdfPCell cell2 = new PdfPCell(new Paragraph("REAL AUDITOR REPORT\n FINANCIAL SITUATION\n PETROL STATION", redFont));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell cell3 = new PdfPCell(new Paragraph("PERIOD OF AUDITING:\n"+fd+" TO "+ld, blueFont));
            cell2.setBorder(0);
            cell3.setBorder(0);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            // a table for products
            PdfPCell pnamecell = new PdfPCell(new Paragraph("Product name"));
            PdfPCell pquantity = new PdfPCell(new Paragraph("Quantity"));
            PdfPCell unitmargin = new PdfPCell(new Paragraph("Unit Margin"));
            PdfPCell grossmargin = new PdfPCell(new Paragraph("Gross Margin"));
            //for pms
            PdfPCell ppnamecell = new PdfPCell(new Paragraph("PMS"));
            PdfPCell ppquantity = new PdfPCell(new Paragraph(pmsq));
            PdfPCell punitmargin = new PdfPCell(new Paragraph(pmsu));
            PdfPCell pgrossmargin = new PdfPCell(new Paragraph(pmsg));
            //ago
            PdfPCell apnamecell = new PdfPCell(new Paragraph("AGO"));
            PdfPCell apquantity = new PdfPCell(new Paragraph(agoq));
            PdfPCell aunitmargin = new PdfPCell(new Paragraph(agou));
            PdfPCell agrossmargin = new PdfPCell(new Paragraph(agog));
            //bik
            PdfPCell bpnamecell = new PdfPCell(new Paragraph("BIK"));
            PdfPCell bpquantity = new PdfPCell(new Paragraph(bikq));
            PdfPCell bunitmargin = new PdfPCell(new Paragraph(biku));
            PdfPCell bgrossmargin = new PdfPCell(new Paragraph(bikg));
            //total
            PdfPCell total = new PdfPCell(new Paragraph("TOTAL:"));
            PdfPCell total1 = new PdfPCell(new Paragraph("UGX "+wtotal));
            total1.setColspan(3);
            total1.setHorizontalAlignment(1);
            total.setBorder(0);
            //total1.setBorder(0);
            products.addCell(pnamecell);
            products.addCell(pquantity);
            products.addCell(unitmargin);
            products.addCell(grossmargin);
            //PMS
            products.addCell(ppnamecell);
            products.addCell(ppquantity);
            products.addCell(punitmargin);
            products.addCell(pgrossmargin);
            //AGO
            products.addCell(apnamecell);
            products.addCell(apquantity);
            products.addCell(aunitmargin);
            products.addCell(agrossmargin);
            //BIK
            products.addCell(bpnamecell);
            products.addCell(bpquantity);
            products.addCell(bunitmargin);
            products.addCell(bgrossmargin);
            products.addCell(total);
            products.addCell(total1);
            //other products
            PdfPCell othername = new PdfPCell(new Paragraph("Product name"));
            PdfPCell turnover = new PdfPCell(new Paragraph("Turnover"));
            PdfPCell rate = new PdfPCell(new Paragraph("Rate"));
            PdfPCell othergross = new PdfPCell(new Paragraph("Gross Margin"));
            //lubricants
            PdfPCell lothername = new PdfPCell(new Paragraph("Lubricant"));
            PdfPCell lturnover = new PdfPCell(new Paragraph(lt));
            PdfPCell lrate = new PdfPCell(new Paragraph(lr));
            PdfPCell lothergross = new PdfPCell(new Paragraph(lg));
            //lpg
            PdfPCell pothername = new PdfPCell(new Paragraph("LPG"));
            PdfPCell pturnover = new PdfPCell(new Paragraph(ltp));
            PdfPCell prate = new PdfPCell(new Paragraph(lrp));
            PdfPCell pothergross = new PdfPCell(new Paragraph(lgp));
            PdfPCell otot = new PdfPCell(new Paragraph("TOTAL:"));
            PdfPCell otot1 = new PdfPCell(new Paragraph("UGX"+ (Integer.parseInt(lg) + Integer.parseInt(lgp))));
            otot1.setColspan(3);
            otot1.setHorizontalAlignment(1);
            otot.setBorder(0);

            otherp.addCell(othername);
            otherp.addCell(turnover);
            otherp.addCell(rate);
            otherp.addCell(othergross);
            otherp.addCell(lothername);
            otherp.addCell(lturnover);
            otherp.addCell(lrate);
            otherp.addCell(lothergross);
            otherp.addCell(pothername);
            otherp.addCell(pturnover);
            otherp.addCell(prate);
            otherp.addCell(pothergross);
            otherp.addCell(otot);
            otherp.addCell(otot1);
//            otherp.addCell(total);
//            products.addCell(total1);
            //Paragraph chapterTitle = new Paragraph("General Report", yellowFont);
            Chapter chapter1 = new Chapter(1);

            chapter1.setNumberDepth(0);
            chapter1.add(table);
            Paragraph sectionTitle = new Paragraph("Income", redFont);
            Section section1 = chapter1.addSection(sectionTitle);

            Paragraph sectionContent = new Paragraph("The table below shows incomes generated from white products\n\n", blueFont);
            Paragraph sectionContent1 = new Paragraph("The table below shows incomes generated from Lubricants and LPG products\n\n", blueFont);
            section1.add(sectionContent);
            section1.add(products);
            section1.add(sectionContent1);
            section1.add(otherp);

            Paragraph section2 = new Paragraph("Real P n L", redFont);
            Section sec2 = chapter1.addSection(section2);
            Paragraph analysis = new Paragraph("Total Creditor: UGX "+tcs+"\n" +
                    "Total Debtors: UGX "+tds+"\n" +
                    "Total Income: UGX "+ti+"\n" +
                    "Total Expenses: UGX "+te+"\n" +
                    "Cash Flow: UGX "+cf+"\n");
            //analysis.setAlignment(Element.ALIGN_CENTER);

            sec2.add(analysis);
            Paragraph section3 = new Paragraph("ANALYSIS OF EVOLUTION OF NET SITUATION", redFont);
            Paragraph nets = new Paragraph("Available Assets: UGX "+aa+"\n" +
                    "Recoverable assets: UGX "+ra+"\n" +
                    "Total Liabilities: UGX "+tl+"\n" +
                    "Expected: UGX "+ee+"\n" +
                    "Real: UGX "+rr+"\n" +
                    "Gap: UGX "+gg);
            Paragraph tlines = new Paragraph("\n" +
                    "\n" +
                    "\n");
            Paragraph preparedby = new Paragraph("Prepared by:\n" +
                    ".............................................\n" +
                    ".............................................\n");
            preparedby.setAlignment(Element.ALIGN_RIGHT);
            Section sec3 = chapter1.addSection(section3);
            sec3.add(nets);
            sec3.add(tlines);
            sec3.add(tlines);
            sec3.add(preparedby);
            sec3.add(tlines);


//            PdfPCell cell3 = new PdfPCell(image, true);
//            PdfPCell cell4 = new PdfPCell(new Paragraph("Cell 4"));
//
//            table.addCell(cell3);
//            table.addCell(cell4);
            document.add(chapter1);
            document.add(new LineSeparator());
            LineSeparator sep = new LineSeparator();
            sep.setOffset(3);
            document.add(sep);
            document.add(new Paragraph("Generated on " + new Date()));

            document.close();
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("StylingExample.pdf"));
//            document.open();
//            //document.add(new Paragraph("Styling Example"));
//
//            //Paragraph with color and font styles
//            Paragraph paragraphOne = new Paragraph("Real Auditor Reports", redFont);
//            document.add(paragraphOne);
//
//            //Create chapter and sections
//            Paragraph chapterTitle = new Paragraph("Chapter Title", yellowFont);
//            Chapter chapter1 = new Chapter(chapterTitle, 1);
//            chapter1.setNumberDepth(0);
//
//            Paragraph sectionTitle = new Paragraph("Section Title", redFont);
//            Section section1 = chapter1.addSection(sectionTitle);
//
//            Paragraph sectionContent = new Paragraph("Section Text content", blueFont);
//            section1.add(sectionContent);
//
//            document.add(chapter1);
//
//            document.close();
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Creating a File chooser

        try {

            File pdfFile = new File(String.valueOf(CAD+".pdf"));
            if (pdfFile.exists()) {

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Awt Desktop is not supported!");
                }

            } else {
                System.out.println("File is not exists!");
            }

            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    }

