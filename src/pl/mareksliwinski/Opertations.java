package pl.mareksliwinski;

import java.util.ArrayList;

public class Opertations {

    public void newOldSameId() {

        ArrayCreator newdata = new ArrayCreator();
        ArrayCreator olddata = new ArrayCreator();
        ArrayList<ArrayCreator> newList;
        ArrayList<ArrayCreator> oldList;

        newdata.loader("new.csv");
        olddata.loader("old.csv");
        ArrayList<ArrayCreator> temp = new ArrayList<>();
        newList = newdata.getList();
        oldList = olddata.getList();

        for (ArrayCreator elem : newList) {
            for (ArrayCreator elem2 : oldList)
                if ((elem.getIdCustomer().equals(elem2.getIdCustomer())))
                    temp.add(elem);
        }
        newDuplicateId(newList);
    }

    public void newDuplicateId(ArrayList<ArrayCreator> newList) {

    }
}

