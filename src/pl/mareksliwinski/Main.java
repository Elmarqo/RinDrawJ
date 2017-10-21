package pl.mareksliwinski;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        caseDivider casedivider = new caseDivider();
        ArrayCreator newdata = new ArrayCreator();
        ArrayCreator olddata = new ArrayCreator();
        Opertations opertations = new Opertations();

        opertations.theSameIdCudtomer();
        //double[] test = casedivider.divider();
        //newdata.loader("new.csv");
        //newdata.loader("old.csv");
    }
}