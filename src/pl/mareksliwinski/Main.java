package pl.mareksliwinski;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        dataLoader newdata = new dataLoader();
        newdata.loader("new.csv");
        System.out.println(newdata.getList().size());
    }
}