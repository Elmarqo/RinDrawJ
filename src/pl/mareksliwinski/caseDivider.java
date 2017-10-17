package pl.mareksliwinski;
import java.util.Scanner;

public class caseDivider{

    private double [] percentList = new double[outFirm.OUTNUMBER];
    private Scanner scanner = new Scanner(System.in);

    /*Getter
    double[] getPercentList() {
        return percentList;
    }*/

    void divider(){
        outFirm outfirm = new outFirm();
        double percentageSum;
        do {
            percentageSum = 0;
            for(int i = 0; i < outFirm.OUTNUMBER; i++){
                System.out.print("Podaj udzial procentowy " + outfirm.getFirmName()[i] + " w przekazywanej transzy: \t");
                percentList[i] = scanner.nextDouble();
                percentageSum += percentList[i];
            }
            if(percentageSum != 100)
                System.out.println("\nSuma udzialow musi sie rownac 100%. Wprowadz dane ponownie:");
        }while (percentageSum != 100);
    }
}