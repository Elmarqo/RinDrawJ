package pl.mareksliwinski;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Opertations {

    public ArrayList<ArrayCreator> newOldTheSameId(ArrayList<ArrayCreator> newList, ArrayList<ArrayCreator> oldList) {

        ArrayList<ArrayCreator> theSame = new ArrayList<>();
        ArrayList<ArrayCreator> uniqueOldList = new ArrayList<>();

        oldList.stream()
                .filter(distinctByKey(ArrayCreator::getIdCustomer))
                .forEach(uniqueOldList::add);

        System.out.println("uniqueOldList size: " + uniqueOldList.size());

        for (ArrayCreator elem : uniqueOldList) {
            Long dataFromUniqueOldList = elem.getIdCustomer();
            newList.stream()
                    .filter(arrayCreator -> arrayCreator.getIdCustomer().equals(dataFromUniqueOldList))
                    .forEach(theSame::add);
        }


        System.out.println("theSame size: " + theSame.size());
        return theSame;
    }

    ArrayList<ArrayCreator> DupNewListId(ArrayList<ArrayCreator> newList) {

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
        return newListDuplicate;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}