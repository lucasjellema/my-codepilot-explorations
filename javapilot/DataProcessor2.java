// class for downloading a csv file from GitHub and storing data in a list of maps
package javapilot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor2 {

    private List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    private String[] columnNames;

    public DataProcessor2(String url) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
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
		// string with url for csv file on github with country data
		String countryCSVFileURL = "https://raw.githubusercontent.com/dr5hn/countries-states-cities-database/master/csv/countries.csv";
		// create DataProcessor2 object

        DataProcessor2 dp = new DataProcessor2(countryCSVFileURL);
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
