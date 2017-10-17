package pl.mareksliwinski;
import java.util.Scanner;

public class caseDivider{

    private String [] outList = {"BMB", "DIAL", "KI"};

    public double[] getPercentList() {
        return percentList;
    }

    private double [] percentList = new double[3];
    private Scanner scanner = new Scanner(System.in);


    void divider(){
        double percentageSum;
        do {
            percentageSum = 0;
            for(int i = 0; i < percentList.length; i++){
                System.out.print("Podaj udzial procentowy firmy " + outList[i] + " w przekazywanej transzy: \t");
                percentList[i] = scanner.nextDouble();
                percentageSum += percentList[i];
            }
        }while (percentageSum != 100);
    }
}