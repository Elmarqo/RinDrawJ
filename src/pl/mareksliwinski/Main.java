package pl.mareksliwinski;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        /*caseDivider casedivider = new caseDivider();
        casedivider.divider();*/

        ArrayCreator newdata = new ArrayCreator();
        ArrayCreator olddata = new ArrayCreator();
        newdata.loader("new.csv");
        olddata.loader("old.csv");
        List<ArrayCreator> newList = newdata.getList();
        List<ArrayCreator> oldList = olddata.getList();
        List<ArrayCreator> repetOldNew;
        List<ArrayCreator> newListDuplicates;
        List<ArrayCreator> finalDrawList;

        Opertations opertations = new Opertations();

        repetOldNew = opertations.newOldTheSameId(newList, oldList);
        newListDuplicates = opertations.dupNewListId(newList);
        finalDrawList = opertations.addNewCasesToFirmAlredyManagedcase(repetOldNew, oldList);
    }
}