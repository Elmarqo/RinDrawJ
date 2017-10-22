package pl.mareksliwinski;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ArrayCreator {

    private String firmName;
    private String caseNumber;
    private double amountDue;
    private Long idCustomer;
    private ArrayList<ArrayCreator> list = new ArrayList<>();

    public ArrayCreator(String firmName, String caseNumber, double amountDue, Long idCustomer) {
        this.firmName = firmName;
        this.caseNumber = caseNumber;
        this.amountDue = amountDue;
        this.idCustomer = idCustomer;
    }

    public String getFirmName() {
        return firmName;
    }

    private void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    private void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public double getAmountDue() {
        return amountDue;
    }

    private void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    private void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public ArrayList<ArrayCreator> getList() {
        return list;
    }

    private void setList(ArrayCreator ArrayCreator) {
        list.add(ArrayCreator);
    }

    public void loader(String fileName) {
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String line;
        System.out.print("\nTrwa wczytywanie pliku " + fileName + "...");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                ArrayCreator set = new ArrayCreator(firmName, caseNumber, amountDue, idCustomer);
                set.setFirmName(split[0]);
                set.setCaseNumber(split[1]);
                set.setAmountDue(Double.parseDouble(split[2]));
                set.setIdCustomer(Long.parseLong(split[3]));
                setList(set);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK.");
        System.out.print("Sortowanie...");
        getList().sort((elem, elem2) ->
                elem.getIdCustomer().compareTo(elem2.getIdCustomer()));
        System.out.println("OK.");

       /* for (ArrayCreator elem : getList()) {
            System.out.print(elem.getFirmName() + "\t");
            System.out.print(elem.getCaseNumber() + "\t");
            System.out.print(elem.getAmountDue() + "\t");
            System.out.println(elem.getIdCustomer());
        }*/
        System.out.println("Wczytano " + decimalFormat.format(getList().size()) + " spraw");
    }
}