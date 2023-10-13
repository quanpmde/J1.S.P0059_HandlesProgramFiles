package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileData {

    private String name;
    private String address;
    private double money;
    List<FileData> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<FileData> getList() {
        return list;
    }

    public void setList(List<FileData> list) {
        this.list = list;
    }

    public List<FileData> readFromFile(String path) {
        List<FileData> data = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String line[] = s.split(";");
                FileData new_data = new FileData();
                new_data.setName(line[0]);
                new_data.setAddress(line[1]);
                double a;
                try {
                    a = Double.parseDouble(line[2]);
                    if(a < 0) new_data.setMoney(0);
                    else new_data.setMoney(a);
                    data.add(new_data);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong nnumber format");
                }
            }
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        return data;
    }

    public boolean writeToFile(String path, List<FileData> data) {
        try {
            File f = new File(path);
            FileWriter fw = new FileWriter(f);
            try (PrintWriter pw = new PrintWriter(fw)) {
                for (FileData d : data) {
                    pw.append(d.toString());
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + ";" + this.getAddress() + ";" + this.getMoney() + "\n";
    }
}