package pl.mareksliwinski;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Opertations {

    public static final int EXISTING_MORE_THEN_ONE_TIME = 1;

    public List<ArrayCreator> newOldTheSameId(List<ArrayCreator> newList, List<ArrayCreator> oldList) {

        String pattern = "###,###.##";
        DecimalFormat dF = new DecimalFormat(pattern);

        /*double amountSum =
                newList.stream()
                        .mapToDouble(ArrayCreator::getAmountDue)
                        .sum();
        System.out.println("suma: " + dF.format(amountSum));*/

        Set<String> tempIdCustomer = oldList.stream().parallel()
                .map(ArrayCreator::getIdCustomer)
                .sorted()
                .collect(Collectors.toSet());
        System.out.println("\nLiczba unikalnych dluznikow w starej transzy: " +
                dF.format(tempIdCustomer.size()));

        List<ArrayCreator> theSame =
                newList.stream().parallel()
                        .filter(ac -> tempIdCustomer.contains(ac.getIdCustomer()))
                        .collect(Collectors.toList());
        System.out.println("Liczba dluznikow przekazanych w poprzednich transzach : " +
                dF.format(theSame.size()));

        return theSame;
    }

    List<ArrayCreator> DupNewListId(List<ArrayCreator> newList) {

        List<ArrayCreator> newListDuplicate = new ArrayList<>();
        /*for (ArrayCreator elem : newList) {
            int index = 0;
            for (ArrayCreator elem2 : newList)
                if (elem.getIdCustomer().equals(elem2.getIdCustomer()))        //dodać drugi warunek na nr sprawy
                    index++;
            if (index > EXISTING_MORE_THEN_ONE_TIME)
                newListDuplicate.add(elem);
        }*/
        double maxi = newList.stream()
                .map(ArrayCreator::getAmountDue)
                .reduce(-22221000.0, Double::max);
        System.out.println("maxi: " + maxi);

        System.out.println(newListDuplicate.size());
        return newListDuplicate;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
