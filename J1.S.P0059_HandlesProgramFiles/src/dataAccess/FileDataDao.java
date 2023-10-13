package dataAccess;

import common.Library;
import common.Validation;
import java.util.Collections;
import java.util.List;
import model.FileData;

public class FileDataDao {

    private static FileDataDao instance = null;
    private static Validation valid = new Validation();

    public static FileDataDao Instance() {
        if (instance == null) {
            synchronized (FileDataDao.class) {
                if (instance == null) {
                    instance = new FileDataDao();
                }
            }
        }
        return instance;
    }

    public String display(FileData data) {
        return String.format("%-20s%-20s%.1f", data.getName(),
                data.getAddress(), data.getMoney());
    }

    public void personInfo(String path, List<FileData> data) {
        data = new FileData().readFromFile(path);
        if (data.isEmpty()) {
            System.out.println("File not found!");
            return;
        }
        Collections.sort(data, new Library());
        double salary = valid.inputDouble("Enter Money");
        String smax = "";
        String smin = "";
        double dmax = Double.MIN_VALUE;
        double dmin = Double.MAX_VALUE;
        int count = 0;
        System.out.printf("%-20s%-20s%s\n", "Name",
                "Address", "Money");
        for (FileData d : data) {
            if (d.getMoney() >= salary) {
                count++;
                System.out.println(display(d));
                if (dmax < d.getMoney()) {
                    dmax = d.getMoney();
                    smax = d.getName();
                }
                if (dmin > d.getMoney()) {
                    dmin = d.getMoney();
                    smin = d.getName();
                }
            }
        }
        if (count == 0) {
            System.out.println("Not found!");
            return;
        }
        if (!smax.isEmpty()) {
            System.out.println("Max: " + smax);
        }
        if (!smin.isEmpty()) {
            System.out.println("Min: " + smin);
        }
    }

    public void copyText() {
        List<FileData> new_data;
        FileData data = new FileData();
        String source = valid.inputString("Enter Source");
        new_data = data.readFromFile(source);
        if (new_data.isEmpty()) {
            System.err.println("File not found!");
            return;
        }
        String filename = valid.inputString("Enter new file name");
        if (!data.writeToFile(filename, new_data)) {
            System.err.println("File not found!");
            return;
        }
        System.out.println("Successful");
    }
}