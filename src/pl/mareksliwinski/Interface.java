package pl.mareksliwinski;

import java.util.List;

public interface Interface {

    public abstract String format(double number);
    public abstract void saveToFile(String filename, List<ArrayCreator> list);
}
