import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class dataLoader {
	
	FileWriter fn = new FileWriter();
	BufferedWriter bw = new BufferedWriter(fw)
	public void loader () throws IOException{
	ArrayList<structureData> listcases = new ArrayList<>();
	String fileName = "new.txt";
		Scanner inFile = new Scanner(new InputStreamReader(new FileInputStream(fileName)));
		int index = inFile.nextInt();
		inFile.nextLine();
		for(int i = 0; i < index; i++){
			structureData set = new structureData();
			set.setoutName(inFile.nextLine());
			set.setoutName(inFile.nextLine());
			set.setdebt(inFile.nextDouble());
			set.setidNumber(inFile.nextLong());
													/*String outName = inFile.nextLine();
													String caseNumber = inFile.nextLine();
													double debt = inFile.nextDouble();
													long idNumber = inFile.nextLong();
													structureData set = new structureData();*/
			listcases.add(set);
		}
		inFile.close();
	}
}