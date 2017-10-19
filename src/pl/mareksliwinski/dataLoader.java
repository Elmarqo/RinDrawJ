package pl.mareksliwinski;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class dataLoader {
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    String string;
    int liczba;

    public void setArry(ArrayList<dataLoader> arry) {
        this.arry = arry;
    }
    ArrayList<dataLoader> arry = new ArrayList<>();

    public void loader(String csvFile) {



        File file = new File(csvFile);
        /*if(file.isFile())
            System.out.println("Plik znajduje się w podanej lokalizacji.");
        else
            System.out.println("Brak pliku w podanej lokalizacji!!!");*/

        String line;
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                dataLoader set = new dataLoader();
                String[] country = line.split(";");
                set.string = country[0];
                //set.liczba = Integer.parseInt(country[0]);
                //set.setString(country[0]);
                set.setLiczba(Integer.parseInt(country[1]));
                //set.setLiczba(index);
                //System.out.println("Country [code= " + country[0] + " , name=" + country[1] + "]");
                arry.add(set);
                //System.out.println(arry.get());
                //System.out.println("Index " + index);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < arry.size(); i++){
            System.out.println(arry.get(i).string);
            System.out.println(arry.get(i).liczba);
        }

        System.out.println(arry.size());

    }
}