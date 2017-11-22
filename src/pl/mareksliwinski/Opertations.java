package pl.mareksliwinski;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Opertations {

    public List<ArrayCreator> newOldTheSameId(List<ArrayCreator> newList, List<ArrayCreator> oldList) {

        String pattern = "###,###.##";
        DecimalFormat dF = new DecimalFormat(pattern);

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
        System.out.println("Liczba dluznikow nowej transzy wystepujaca w poprzednich transzach: " +
                dF.format(theSame.size()));

        return theSame;
    }

    List<ArrayCreator> dupNewListId(List<ArrayCreator> newList) {

        Set<String> temp = new HashSet<>();
        Set<String> tempDuplicates = newList.stream()
                .map(ArrayCreator::getIdCustomer)
                .filter(p -> !temp.add(p))
                .collect(Collectors.toSet());
        temp.clear();

        List<ArrayCreator> newListDuplicates = newList.stream()
                .filter(p -> tempDuplicates.contains(p.getIdCustomer()))
                .collect(Collectors.toList());
        tempDuplicates.clear();

        System.out.println("Lista duplicatow: " + newListDuplicates.size());
        return newListDuplicates;
    }
}
