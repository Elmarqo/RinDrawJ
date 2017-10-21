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
        int index = 0;
        for (int i = 0; i < 300; i++) {
            Long a = newList.get(i).getIdCustomer();
            System.out.print(a + "\t");
            System.out.print(oldList.get(i).getIdCustomer() + "\t");
            System.out.println(oldList.get(i).getIdCustomer() - a);
            if ((oldList.get(i).getIdCustomer().equals(a))) {
                index++;
            }

        }

        System.out.println("999AAAAAAA: " + index);
        //System.out.println(oldList.get(0).getIdCustomer());


    }
}