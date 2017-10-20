package pl.mareksliwinski;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class dataLoader {

    private String firmName;
    private String caseNumber;
    private double amountDue;
    private Long idCustomer;
    private ArrayList<dataLoader> list = new ArrayList<>();

    public String getFirmName() {
        return firmName;
    }

    private void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public double getAmount() {
        return amountDue;
    }

    private void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    private void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    ArrayList<dataLoader> getList() {
        return list;
    }

    public void setList(ArrayList<dataLoader> list) {
        this.list = list;
    }

    public void loader(String fileName) {
        String pattern = "###,###.###";
        DecimalFormat df = new DecimalFormat(pattern);
        ArrayList<dataLoader> caseList = new ArrayList<>();
        String line;
        System.out.println("");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                dataLoader set = new dataLoader();
                String[] split = line.split(";");
                set.firmName = split[0];
                set.caseNumber = split[1];
                set.setAmountDue(Double.parseDouble(split[2]));
                set.setIdCustomer(Long.parseLong(split[3]));
                caseList.add(set);
                //Collections.sort(caseList, (dataLoader elem, dataLoader elem2) -> elem.idCustomer.compareTo(elem2.idCustomer));
                //Collections.sort(personList, (dataLoader p1, Person p2) -> p1.firstName.compareTo(p2.firstName));
            }
        } catch (IOException e) {
            System.out.println("Wczytano " + caseList.size() + " spraw");
            e.printStackTrace();
        }
        caseList.sort((elem, elem2) -> {
            return elem.idCustomer.compareTo(elem2.idCustomer);
        });
        //Comparator.comparing()

        for (dataLoader elem : caseList) {
            System.out.print(elem.firmName + "\t");
            System.out.print(elem.caseNumber + "\t");
            System.out.print(elem.amountDue + "\t");
            System.out.println(elem.idCustomer);
        }
        System.out.println("Wczytano " + df.format(caseList.size()) + " spraw");
    }
}