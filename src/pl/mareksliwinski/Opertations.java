package pl.mareksliwinski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Opertations {

    public void newOldSameId(ArrayCreator newdata, ArrayCreator olddata) {

        ArrayList<ArrayCreator> newList = newdata.getList();
        ArrayList<ArrayCreator> oldList = newdata.getList();
        ArrayList<ArrayCreator> temp = new ArrayList<>();

        newdata.loader("new.csv");
        olddata.loader("old.csv");

        System.out.println(newList.get(451).getAmountDue());

        Comparator<ArrayCreator> comp = new Comparator<ArrayCreator>() {
            @Override
            public int compare(ArrayCreator elem, ArrayCreator elem2) {
                return elem.getIdCustomer().compareTo(elem2.getIdCustomer());
            }
        };

        /*int index = Collections.binarySearch(newList, new ArrayCreator(null, null, null, 72), comp);
        if (index >= 0)
            System.out.println(index);*/
    }


    public void DupNewListId(ArrayList<ArrayCreator> newList) {

    }
}