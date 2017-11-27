package pl.mareksliwinski;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import static java.util.Comparator.comparing;

public class ArrayCreator {

    private String firmName;
    private String caseNumber;
    private double amountDue;
    private String idCustomer;
    private List<ArrayCreator> list = new ArrayList<>();

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

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<ArrayCreator> getList() {
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
                set.setFirmName(split[0].trim());
                set.setCaseNumber(split[1].trim());
                set.setAmountDue(Double.parseDouble(split[2].trim()));
                set.setIdCustomer (split[3].trim());
                setList(set);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(decimalFormat.format(getList().size()) + " rekordow OK.");
        System.out.print("Sortowanie...");
        sortByIDCustomer(getList());
        //sortByAmountDue(getList());
        System.out.println("OK.");
    }

    public static final Comparator<ArrayCreator> BY_AMOUNT_DUE
            = comparing(ArrayCreator::getAmountDue);

    public void sortByAmountDue(ArrayList<ArrayCreator> list) {
        getList().sort(BY_AMOUNT_DUE);
    }

    public void sortByIDCustomer(List<ArrayCreator> list) {
        list.sort((elem, elem2) ->
                elem.getIdCustomer().compareTo(elem2.getIdCustomer()));
    }

    @Override
    public String toString() {
        return "[FIRM: " + firmName + ", Case no: " + caseNumber + ", Amount Due: " + amountDue + ", ID: " + idCustomer + "]\n";
    }
}