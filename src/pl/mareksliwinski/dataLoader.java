package pl.mareksliwinski;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class dataLoader {

    private String firmName;
    private String caseNumber;
    private double amountDue;
    private long idCustomer;
    private ArrayList<dataLoader> list = new ArrayList<>();

    private String getFirmName() {
        return firmName;
    }
    private void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    private String getCaseNumber() {
        return caseNumber;
    }

    private void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    private double getAmountDue() {
        return amountDue;
    }

    private void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    private Long getIdCustomer() {
        return idCustomer;
    }

    private void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    private ArrayList<dataLoader> getList() {
        return list;
    }

    private void setList(dataLoader dataloader) {
        list.add(dataloader);
    }

    public void loader(String fileName) {
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String line;
        //System.out.println("");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                dataLoader set = new dataLoader();
                String[] split = line.split(";");
                set.setFirmName(split[0]);
                set.setCaseNumber(split[1]);
                set.setAmountDue(Double.parseDouble(split[2]));
                set.setIdCustomer(Long.parseLong(split[3]));
                setList(set);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getList().sort((elem, elem2) ->
            elem.getIdCustomer().compareTo(elem2.getIdCustomer()));

        /*for (dataLoader elem : getList()) {
            System.out.print(elem.getFirmName() + "\t");
            System.out.print(elem.getCaseNumber() + "\t");
            System.out.print(elem.getAmountDue() + "\t");
            System.out.println(elem.getIdCustomer());
        }*/
        System.out.println("Wczytano " + decimalFormat.format(getList().size()) + " spraw");
    }
}