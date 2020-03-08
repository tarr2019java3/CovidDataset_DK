package pl.sda.coviddataset;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {


    // tworze obiekt Record, uzupełniam go danymi

    // private int sno;
    //    private String date;
    //    private String province;
    //    private String country;
    //    private String lastUpdate;
    //    private double confirmed;
    //    private double deaths;
    //    private double recovered;

    // dodaje obiekt Record na liste typu Record
    // zapisujemy do jsona
    // *tworzymy mape w ktorej kluczem jest kolumna Country
    // a wartosciami lista przypadkow z danego kraju
    // efekt:
    // Us
    //         -przypadek1
    //         -przypadek2    .. itd

    private Path path;

    public void openFile(String filename){

        path = Paths.get(filename);

        try {
           List<String> lines = Files.readAllLines(path);
           List<Record> records = new ArrayList<>();
           lines.remove(0);

           for(String line : lines) {
               String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
               Record record = new Record();
               record.setSno(Integer.parseInt(columns[0]));
               record.setDate(columns[1]);
               record.setProvince(columns[2]);
               record.setCountry(columns[3]);
               record.setLastUpdate(columns[4]);
               record.setConfirmed(Double.parseDouble(columns[5]));
               record.setDeaths(Double.parseDouble(columns[6]));
               record.setRecovered(Double.parseDouble(columns[7]));
               records.add(record);
           }

           ObjectMapper objectMapper = new ObjectMapper();
           objectMapper.writeValue(new File("koronawirus.json"), records);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
