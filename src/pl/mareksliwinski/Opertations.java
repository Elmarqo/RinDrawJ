package pl.mareksliwinski;

import java.util.*;

public class Opertations {

    public ArrayList<ArrayCreator> newOldTheSameId(ArrayList<ArrayCreator> newList, ArrayList<ArrayCreator> oldList) {

        Set<Long> set = new HashSet<>();
        ArrayList<ArrayCreator> theSame = new ArrayList<>();

        for (ArrayCreator elem : oldList)
            set.add(elem.getIdCustomer());

        int index = 0;
        for (ArrayCreator elem : newList) {
            for (Long elem2 : set) {
                if (elem.getIdCustomer().equals(elem2)) {
                    index++;
                    theSame.add(elem);
                }
            }
        }
       /* System.out.println(set.size());
        System.out.println(index);
        System.out.println(theSame.size());*/
        //oldList.clear();
        return theSame;
    }


    public void DupNewListId(ArrayList<ArrayCreator> theSame) {

    }
}