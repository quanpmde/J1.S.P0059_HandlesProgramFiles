package repository;

import common.Validation;
import dataAccess.FileDataDao;
import java.util.List;
import model.FileData;

public class FileDataRepository implements IFIleDataRepsitory {

    protected Validation valid = new Validation();

 
    @Override
    public void personInfo(List<FileData> data) {
        String path = valid.inputString("Enter path");
        FileDataDao.Instance().personInfo(path, data);
    }


    @Override
    public void copyText() {
        FileDataDao.Instance().copyText();
    }
}
