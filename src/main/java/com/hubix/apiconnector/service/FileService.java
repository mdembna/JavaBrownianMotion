package com.hubix.apiconnector.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {

    public File getFile() throws IOException {
        String path = new File("").getAbsolutePath();
        String dirName = "\\data";
        String fileName = "\\real-time-data.txt";
        File dir = new File(path + dirName);
        File txt = new File(path + dirName + fileName);
        boolean filesCreated = dir.mkdir() && txt.createNewFile();
        return filesCreated ? txt : null;
    }

    public void writeDataToFile(File file, String string) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] fileContent = string.getBytes();
        fileOutputStream.write(fileContent);
    }
}
