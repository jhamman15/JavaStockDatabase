import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Collections;

public class StockDatabase {

    private ArrayList<StockEntry> database;

    public StockDatabase(){
        database = new ArrayList<StockEntry>();
    }

    public ArrayList<StockEntry> getDatabase() {
        return database;
    }

    //return object with highest high value
    public StockEntry GetHighestValue(){
        double max = 0;
        StockEntry result = null;

        for(StockEntry s : database){
            if(s.getHigh() > max){
                max = s.getHigh();
                result = s;
            }
        }
        return result;
    }

    //return sublist of 5 highest values
    public ArrayList<StockEntry> getTopFiveHighValues(){
        ArrayList<StockEntry> result = new ArrayList<StockEntry>();
        ArrayList<StockEntry> list = database;
        Collections.sort(list);
        for(int i = 0; i < 5; i++){
            result.add(list.get(i));
        }
        return result;
    }

    //return list of stocks with low below 200
    public ArrayList<StockEntry> getLowUnderTwoHundred(){
        ArrayList<StockEntry> result = new ArrayList<StockEntry>();
        ArrayList<StockEntry> list = database;
        Collections.sort(list);
        double low;

        for(StockEntry s : list){
            if(s.getLow() < 200){
                low = s.getLow();
                result.add(s);
            }
        }
        return result;
    }

    //return stock with lowest opening value
    public StockEntry getLowestOpen(){
        double open = 10000;
        StockEntry result = null;

        for(StockEntry s : database){
            if(s.getOpen() < open){
                open = s.getOpen();
                result = s;
            }
        }
        return result;
    }

    //return stocks with close value less than open value
    public ArrayList<StockEntry> getCloseLessThanOpen(){
        ArrayList<StockEntry> result = new ArrayList<StockEntry>();
        ArrayList<StockEntry> list = database;
        Collections.sort(list);
        double close;

        for(StockEntry s : list){
            if(s.getClose() < s.getOpen()){
                close = s.getClose();
                result.add(s);
            }
        }
        return result;
    }

    public int countRecords (){
        return database.size();
    }

    public void readStockData(String filename){
        FileInputStream fileByteStream = null;
        Scanner scanner = null;
        try{
            //open file
            fileByteStream = new FileInputStream(filename);
            scanner = new Scanner(fileByteStream);
            scanner.useDelimiter("[,\r\n]+");

            scanner.nextLine();
            while(scanner.hasNext()){
                String date = scanner.next();
                double open = scanner.nextDouble();
                double high = scanner.nextDouble();
                double low = scanner.nextDouble();
                double close = scanner.nextDouble();

                StockEntry tempEntry = new StockEntry(date, open, high, low, close);

                database.add(tempEntry);
            }
            fileByteStream.close();
        }
        catch(IOException error1){
            System.out.println("Error with file" + filename);
        }
    }
}
