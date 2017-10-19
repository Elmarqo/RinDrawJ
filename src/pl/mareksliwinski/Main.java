package pl.mareksliwinski;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        /*caseDivider casedivider = new caseDivider();
        casedivider.divider();*/
        //ArrayList<structureData> listcases = new ArrayList<>();

        structureData newdata = new structureData();
        newdata.loader("new.txt");
        //System.out.println(newdata.getList().get(0).getDebt());
    }
}