package pl.mareksliwinski;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class structureData {

    private String outName;
    private String caseNumber;
    private double debt;
    private long idNumber;
    ArrayList<structureData> list = new ArrayList<>();

    public ArrayList<structureData> getList() {
        return list;
    }

    public void setList(ArrayList<structureData> list) {
        this.list = list;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

	/*public structureData (String outName, String caseNumber, double debt, long idNumber){
		this.outName = outName;
		this.caseNumber = caseNumber;
		this.debt = debt;
		this.idNumber = idNumber;
	}*/

    public void loader(String fileName) throws IOException{
        File file  = new File("test.txt");
        /*Scanner fileLoader = new Scanner(new InputStreamReader(new FileInputStream(fileName)));
        int index = fileLoader.nextInt();
        fileLoader.nextLine();
        structureData set = new structureData();

        for(int i = 0; i < index; i++) {
            set.setOutName(fileLoader.nextLine());
            set.setCaseNumber(fileLoader.nextLine());
            set.setDebt(fileLoader.nextDouble());
            set.setIdNumber(fileLoader.nextLong());
            list.add(set);
        }*/
    }
}