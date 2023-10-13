package controller;

import model.FileData;
import repository.FileDataRepository;
import view.Menu;

public class FileDataController extends Menu {

    protected static String[] mc = {"Find person info", "Copy Text to new file", "Exit"};
    protected FileDataRepository repo;
    protected FileData data;

    public FileDataController() {
        super("========== File Processing =========", mc);
        repo = new FileDataRepository();
        data = new FileData();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("--------- Person info ---------");
                repo.personInfo(data.getList());
                break;
            }
            case 2: {
                System.out.println("------------- Copy text --------------");
                repo.copyText();
                break;
            }
            case 3: {
                System.out.println("EXIT...");
                System.exit(0);
            }
            default: {
                System.out.println("No such choice");
            }
        }
    }
}