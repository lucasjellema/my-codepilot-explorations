// class for loading a csv file and storing data in a list of maps
package javapilot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor {

    private List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    private String[] columnNames;

    public DataProcessor(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line = br.readLine();
            columnNames = line.split(",");
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> map = new HashMap<String, String>();
                for (int i=0; i<values.length; i++) {
                    map.put(columnNames[i], values[i]);
                }
                data.add(map);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
		}
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor("data.csv");
		// print names of columns
        for (String name : dp.getColumnNames()) {
            System.out.print(name + " ");
        }
        System.out.println();
		// print data
        for (Map<String, String> map : dp.getData()) {
            for (String key : dp.getColumnNames()) {
                System.out.print(map.get(key) + " ");
            }
            System.out.println();
        }
    }
}