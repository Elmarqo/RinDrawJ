package pl.mareksliwinski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Opertations implements Interface {

    public static final int FIRMS_No_SUBTRACT_1 = OutFirm.values().length - 1;
    String[] firmName = {"BMB", "DIAL", "KI"};

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
        saveToFile("repetition.txt", repetition);
        return repetition;
    }

    List<ArrayCreator> dupNewListId(List<ArrayCreator> newList) {

        Set<String> temp = new HashSet<>();
        Set<String> tempDuplicates = newList.stream()
                .map(ArrayCreator::getIdCustomer)
                .filter(p -> !temp.add(p))
                .collect(Collectors.toSet());
        temp.clear();

        List<ArrayCreator> newListDuplicates = newList.stream().parallel()
                .filter(p -> tempDuplicates.contains(p.getIdCustomer()))
                .collect(Collectors.toList());
        tempDuplicates.clear();

        System.out.println("Lista duplikatow: " + format(newListDuplicates.size()));
        saveToFile("newListDuplicates.txt", newListDuplicates);
        return newListDuplicates;
    }

    List<ArrayCreator> addNewCasesToFirmAlredyManagedcase(List<ArrayCreator> repetition, List<ArrayCreator> oldList) {

        List<ArrayCreator> finalDrawList = new ArrayList<>();

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
        System.out.println("Liczba wylosowanych spraw: " + format(finalDrawList.size()));
        return finalDrawList;
    }

    List<ArrayCreator> removeRepetitionDup(List<ArrayCreator> repetition) {

        List<ArrayCreator> repDistinct = repetition.stream().parallel()
                .filter(distinctByKey(ArrayCreator::getIdCustomer))
                .collect(Collectors.toList());

        System.out.println("Rep: " + format(repDistinct.size()));
        return repDistinct;
    }

    List<ArrayCreator> removeRepDistinctFromNewListDuplicate(List<ArrayCreator> repDistinct, List<ArrayCreator> newListDuplicate) {

        List<String> temp = repDistinct.stream()
                .map(ArrayCreator::getIdCustomer)
                .collect(Collectors.toList());

        for (int i = 0; i < newListDuplicate.size(); i++) {
            int as = temp.indexOf(newListDuplicate.get(i).getIdCustomer());
            if (as >= 0) {
                newListDuplicate.remove(i);
                i--;
            }
        }
        System.out.println("BBBBB " + newListDuplicate.size());
        return newListDuplicate;
    }

    List<ArrayCreator> addRepeatingDebtors(List<ArrayCreator> newListDuplicate, List<ArrayCreator> finalDrawList) {

        ArrayCreator ac = new ArrayCreator();
        ac.setIdCustomer("0");
        newListDuplicate.add(newListDuplicate.size(), ac);

        int k = 0;
        for (int i = 0; i < newListDuplicate.size() - 1; i++) {
            int counter = 0;
            for (int j = 0; j < newListDuplicate.size(); j++) {
                if (!newListDuplicate.get(i).getIdCustomer().contains(newListDuplicate.get(i + 1).getIdCustomer())) {
                    counter++;
                    k++;
                }
                k = (k > FIRMS_No_SUBTRACT_1) ? 0 : k;
                int c = k - counter;
                c = (c < 0) ? FIRMS_No_SUBTRACT_1 : c;
                ArrayCreator temp = new ArrayCreator();
                temp.setFirmName(firmName[c]);
                temp.setCaseNumber(newListDuplicate.get(i).getCaseNumber());
                temp.setAmountDue(newListDuplicate.get(i).getAmountDue());
                temp.setIdCustomer(newListDuplicate.get(i).getIdCustomer());
                finalDrawList.add(temp);
                break;
            }
        }
        saveToFile("finalDrawList.txt", finalDrawList);
        System.out.println("Liczba wylosowanych spraw: " + format(finalDrawList.size()));
        return finalDrawList;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Override
    public String format(double number) {
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }

    @Override
    public void saveToFile(String fileName, List<ArrayCreator> list){
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();

            for(ArrayCreator elem : list){
                bw.write(elem.getFirmName() + "\t");
                bw.write(elem.getCaseNumber() + "\t");
                bw.write(elem.getAmountDue() + "\t");
                bw.write(elem.getIdCustomer() + "\n");
            }
            System.out.println("Plik \"" + fileName + "\" zostal zapisany w katalogu aplikacji.");

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}