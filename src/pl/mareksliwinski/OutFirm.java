package pl.mareksliwinski;

public enum OutFirm {
    BMB, DIALTONE, KI;

    private String [] firmName = {"BMB", "DIALTONE", "KI"};

    public String[] getFirmName() {
        return firmName;
    }

}