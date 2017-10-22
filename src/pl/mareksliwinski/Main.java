package pl.mareksliwinski;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String firmName = null;
        String caseNumber = null;
        double amountDue = 0.0;
        Long idCustomer = null;

        caseDivider casedivider = new caseDivider();
        ArrayCreator newdata = new ArrayCreator(firmName, caseNumber, amountDue, idCustomer);
        ArrayCreator olddata = new ArrayCreator(firmName, caseNumber, amountDue, idCustomer);
        Opertations opertations = new Opertations();

        opertations.newOldSameId(newdata, olddata);


    }
}