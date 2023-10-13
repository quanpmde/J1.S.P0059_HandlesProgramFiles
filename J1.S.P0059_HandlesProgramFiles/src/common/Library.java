package common;

import java.util.Comparator;
import model.FileData;

public class Library implements Comparator<FileData> {

    @Override
    public int compare(FileData o1, FileData o2) {
        if (o1.getMoney() > o2.getMoney()) {
            return 1;
        }
        if (o1.getMoney() < o2.getMoney()) {
            return -1;
        }
        return 0;
    }
}