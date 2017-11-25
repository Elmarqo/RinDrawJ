package pl.mareksliwinski;

import java.util.Scanner;


public class caseDivider {

    private double[] percentList = new double[OutFirm.values().length];
    private Scanner scanner = new Scanner(System.in);

    public double[] getPercentList() {
        return percentList;
    }


    public double[] divider() {
        double percentageSum;
        do {
            percentageSum = 0;
            for (int i = 0; i < OutFirm.values().length; i++) {
                System.out.print("Podaj udzial procentowy " + OutFirm.values()[i] + " w przekazywanej transzy: \t");
                percentList[i] = scanner.nextDouble();
                percentageSum += percentList[i];
            }
            if (percentageSum != 100)
                System.out.println("\nSuma udzialow musi sie rownac 100%. Wprowadz dane ponownie:");
        } while (percentageSum != 100);
        return percentList;
    }
}