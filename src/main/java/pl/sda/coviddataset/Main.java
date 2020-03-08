package pl.sda.coviddataset;

public class Main {

    public static void main(String[] args) {
	// write your code here
//    String s = "14,01/22/2020 12:00:00,Hubei,China,01/22/2020 12:00:00,444.0,0.0,0.0";
//    String[] tab = s.split(",");
//        System.out.println(tab[1]);

    FileUtils fileUtils = new FileUtils();
    fileUtils.openFile("2019_nCoV_data.csv");


    }
}

