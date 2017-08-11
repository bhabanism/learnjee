package com.bsm.dataaccess;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CSVDataAccess {
    private static final String DATA_SOURCE = "data.csv";
    
    public static List<String> getData() throws Exception {
        return readFile(DATA_SOURCE);        
    }

    public static void updateData(List<String> list) throws Exception {
        writeFile(DATA_SOURCE, list);        
    }

    private static List<String> readFile(@SuppressWarnings("SameParameterValue") String filePath) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            List<String> list = new ArrayList<String>();
            stream.forEach(list::add);
            return new ArrayList<>(list);
        }
    }

    private static void writeFile(String filePath, List<String> list) throws Exception {
        Files.write(Paths.get(filePath), (Iterable<String>)list.stream()::iterator);
    }


    public static void main(String[] args) {
        try {
            List<String> list = getData();
            for(String line : list) {
                System.out.println(line);
            }
            list.add("new data 10");
            writeFile("data_new.csv", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
