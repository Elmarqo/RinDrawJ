package pl.mareksliwinski;

import jdk.internal.jline.internal.TestAccessible;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import static java.util.Comparator.comparing;

public class ArrayCreator {

    public static final Comparator<ArrayCreator> BY_ID_CUSTOMER
            = comparing(ArrayCreator::getIdCustomer);
    public static final Comparator<ArrayCreator> BY_AMOUNT_DUE
            = comparing(ArrayCreator::getAmountDue);

    private String firmName;
    private String caseNumber;
    private double amountDue;
    private Long idCustomer;
    private ArrayList<ArrayCreator> list = new ArrayList<>();

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        if (amountDue < 0) {
            System.out.println("Kwota nie moze byc mniejsza od 0.");
        } else {
            this.amountDue = amountDue;
        }
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public ArrayList<ArrayCreator> getList() {
        return list;
    }

    public void setList(ArrayCreator arrayCreator) {
        list.add(arrayCreator);
    }

    public void loader(String fileName) {
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String line;
        System.out.print("\nTrwa wczytywanie pliku " + fileName + "... ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                ArrayCreator set = new ArrayCreator();
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
        System.out.println(decimalFormat.format(getList().size()) + " rekordow OK.");
        System.out.print("Sortowanie...");
        /*getList().sort((elem, elem2) ->
                elem.getIdCustomer().compareTo(elem2.getIdCustomer()));*/
        getList().sort(ArrayCreator.BY_ID_CUSTOMER);
        System.out.println("OK.");

       /* for (ArrayCreator elem : getList()) {
            System.out.print(elem.getFirmName() + "\t");
            System.out.print(elem.getCaseNumber() + "\t");
            System.out.print(elem.getAmountDue() + "\t");
            System.out.println(elem.getIdCustomer());
        }*/
        //System.out.println("Wczytano " + decimalFormat.format(getList().size()) + " spraw");
    }
}