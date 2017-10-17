package pl.mareksliwinski;

public class Main {

    public static void main(String[] args) {
        caseDivider casedivider = new caseDivider();
        casedivider.divider();

        for(double elem : casedivider.getPercentList())
            System.out.println(elem);
    }
}