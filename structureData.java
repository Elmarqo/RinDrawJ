public class structureData{

	
	private String outName;
	private String caseNumber;
	private double debt;
	private long idNumber;
	
	/*public structureData (String outName, String caseNumber, double debt, long idNumber){
		this.outName = outName;
		this.caseNumber = caseNumber;
		this.debt = debt;
		this.idNumber = idNumber;
	}*/
	
	//Setters
	void setoutName(String outName){
		this.outName = outName;
	}
	void setcaseNumber(String caseNumber){
		this.caseNumber = caseNumber;
	}
	void setdebt(double debt){
		this.debt = debt;
	}
	void setidNumber(long idNumber){
		this.idNumber = idNumber;
	}
	
	//Getters
	String getoutName(){
		return outName;
	}
	String getcaseNumber(){
		return caseNumber;
	}
	double getdebt(){
		return debt;
	}
	long getidNumber(){
		return idNumber;
	}
}
