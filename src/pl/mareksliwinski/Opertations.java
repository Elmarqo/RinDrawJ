package pl.mareksliwinski;

import java.util.*;

public class Opertations {

    public ArrayList<ArrayCreator> newOldTheSameId(ArrayList<ArrayCreator> newList, ArrayList<ArrayCreator> oldList) {

        Set<Long> set = new TreeSet<>();
        ArrayList<ArrayCreator> theSame = new ArrayList<>();
        ArrayList temp = new ArrayList<>();


        for (ArrayCreator elem : oldList)
            set.add(elem.getIdCustomer());

        for (ArrayCreator elem : newList) {
            for (Long elem2 : set) {
                if (elem.getIdCustomer().equals(elem2))
                    theSame.add(elem);
            }
        }
        for (ArrayCreator elem : newList){
            System.out.println(elem.getAmountDue());
        }

        System.out.println(set.size());
        //System.out.println(temp.size());
        System.out.println(theSame.size());
        return theSame;
    }

    public void DupNewListId(ArrayList<ArrayCreator> newList) {

        ArrayList<ArrayCreator> newListDuplicate = new ArrayList<>();
        for (ArrayCreator elem : newList) {
            int index = 0;
            for (ArrayCreator elem2 : newList)
                if (elem.getIdCustomer().equals(elem2.getIdCustomer()))        //dodać drugi warunek na nr sprawy
                    index++;
            if (index > 1)
                newListDuplicate.add(elem);
        }
        System.out.println(newListDuplicate.size());
    }
}