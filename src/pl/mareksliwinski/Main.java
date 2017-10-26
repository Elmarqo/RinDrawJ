package pl.mareksliwinski;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        /*caseDivider casedivider = new caseDivider();
        casedivider.divider();*/

        ArrayCreator newdata = new ArrayCreator();
        ArrayCreator olddata = new ArrayCreator();
        newdata.loader("new.csv");
        olddata.loader("old.csv");
        ArrayList<ArrayCreator> newList = newdata.getList();
        ArrayList<ArrayCreator> oldList = olddata.getList();
        ArrayList<ArrayCreator> temp;

        Opertations opertations = new Opertations();

        temp = opertations.newOldTheSameId(newList, oldList);
        oldList.clear();

        opertations.DupNewListId(temp);
    }
}