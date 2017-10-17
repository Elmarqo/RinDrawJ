package pl.mareksliwinski;

public class structureData{

	private String outName;
	private String caseNumber;
	private float debt;
	private long idNumber;
	private double go;

	//Setters
	void setoutName(String outName){
		this.outName = outName;
	}
	void setcaseNumber(String caseNumber){
		this.caseNumber = caseNumber;
	}
	void setdebt(float debt){
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
	float getdebt(){
		return debt;
	}
	long getidNumber(){
		return idNumber;
	}
}
