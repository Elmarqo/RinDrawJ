package pl.mareksliwinski;



import java.util.ArrayList;

public class Opertations {

    public void theSameIdCudtomer() {

        ArrayCreator newdata = new ArrayCreator();
        ArrayCreator olddata = new ArrayCreator();
        ArrayList<ArrayCreator> newList = new ArrayList<>();
        ArrayList<ArrayCreator> oldList = new ArrayList<>();

        newdata.loader("new.csv");
        olddata.loader("old.csv");

        newList = newdata.getList();
        oldList = olddata.getList();


        System.out.println("nowy rozmiar newdata: " + newList.size());


    }
}