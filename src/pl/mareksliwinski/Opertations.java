package pl.mareksliwinski;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Opertations implements Interface {

    public List<ArrayCreator> newOldTheSameId(List<ArrayCreator> newList, List<ArrayCreator> oldList) {

        Set<String> tempIdCustomer = oldList.stream().parallel()
                .map(ArrayCreator::getIdCustomer)
                .sorted()
                .collect(Collectors.toSet());
        System.out.println("\nLiczba unikalnych dluznikow w starej transzy: " +
                format(tempIdCustomer.size()));

        List<ArrayCreator> repetition =
                newList.stream().parallel()
                        .filter(ac -> tempIdCustomer.contains(ac.getIdCustomer()))
                        .collect(Collectors.toList());
        System.out.println("Liczba dluznikow nowej transzy wystepujaca w poprzednich transzach: " +
                format(repetition.size()));

        return repetition;
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

        System.out.println("Lista duplikatow: " + format(newListDuplicates.size()));
        return newListDuplicates;
    }

    List<ArrayCreator> addNewCasesToFirmAlredyManagedcase(List<ArrayCreator> repetition, List<ArrayCreator> oldList) {

        List<ArrayCreator> finalDrawList = new ArrayList<>();

        System.out.println("Zero: " + repetition.get(0).getIdCustomer());

        for (ArrayCreator elem : repetition) {
            for (ArrayCreator elem2 : oldList)
                if (elem.getIdCustomer().contains(elem2.getIdCustomer())) {
                    ArrayCreator temp = new ArrayCreator();
                    temp.setFirmName(elem2.getFirmName());
                    temp.setCaseNumber(elem.getCaseNumber());
                    temp.setAmountDue(elem.getAmountDue());
                    temp.setIdCustomer(elem.getIdCustomer());
                    finalDrawList.add(temp);
                    break;
                }
        }
        System.out.println("Rozmiar finalDrawList: " + finalDrawList.size());
        System.out.println(finalDrawList);

        return finalDrawList;
    }

    @Override
    public String format(double number) {
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }
}