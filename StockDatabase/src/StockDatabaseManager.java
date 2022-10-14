import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StockDatabaseManager {

    public static void printContents(ArrayList<StockEntry> list){
        for(StockEntry se : list) {
            System.out.println(se);
        }
    }

    public static void main(String[] args) {

        StockDatabase db = new StockDatabase();
        db.readStockData("data/stock_data.csv");

        //prints entire database
        //printContents(db.getDatabase());
        //db.getDatabase().forEach(System.out::println);

        //****Using Methods****//
        //prints highest value using method
        System.out.println("\nMethod printing highest high");
        StockEntry r = db.GetHighestValue();
        System.out.println("Day with the highest value: " + r.getDate() + ", with a value of: " + r.getHigh());

        //prints highest 5 using method
        System.out.println("\nMethod printing top 5 highs");
        ArrayList<StockEntry> l = db.getTopFiveHighValues();
        printContents(l);

        //prints all stocks with low under 200
        System.out.println("\nMethod printing stocks with low under $200");
        ArrayList<StockEntry> list = db.getLowUnderTwoHundred();
        printContents(list);

        //prints out stock with lowest open
        System.out.println("\nMethod printing stocks with lowest opening value");
        StockEntry e = db.getLowestOpen();
        System.out.println("Day with the lowest open value: " + e.getDate() + ", with a value of: " + e.getOpen());

        //prints out stocks with close value less than open value
        System.out.println("\nMethod printing stocks with close value less than opening value");
        ArrayList<StockEntry> listcloselessthanopen = db.getCloseLessThanOpen();
        printContents(listcloselessthanopen);

        //****Using Streams****//
        //prints high greater than 100 using stream
        System.out.println("\nStream printing stocks with high greater than $100");
        List<StockEntry> highGreaterThan100 = db.getDatabase().stream()
                .filter(stockEntry -> stockEntry.getHigh() > 100).collect(Collectors.toList());
        highGreaterThan100.forEach(System.out::println);

        //prints high using stream
        System.out.println("\nStream printing highest high");
        db.getDatabase().stream().max(Comparator.comparing(StockEntry::getHigh))
                .ifPresent(s -> {
                    System.out.println("Day with the highest value: " + s.getDate() + ", with a value of: " + s.getHigh());
                });

        //prints highest 5 using stream
        System.out.println("\nStream printing top 5 highs");
        List<StockEntry> topFiveHighValues = db.getDatabase().stream().sorted(Comparator.comparing(StockEntry::getHigh).reversed())
                .limit(5).collect(Collectors.toList());
        topFiveHighValues.forEach(System.out::println);

        //prints stocks with low under 200 using stream
        System.out.println("\nStream printing out lows under 200");
        List<StockEntry> lowUnderTwoHundred = db.getDatabase().stream().filter(stockEntry -> stockEntry.getLow() < 200).collect(Collectors.toList());
        lowUnderTwoHundred.forEach(System.out::println);

        //prints out stock with lowest open using stream
        System.out.println("\nStream printing out lowest open value");
        Stream<StockEntry> lowestOpen = db.getDatabase().stream().sorted(Comparator.comparing(StockEntry::getOpen)).limit(1);
        lowestOpen.forEach(System.out::println);
//
        //stream printing out stocks with closing value less than opening
        System.out.println("\nStream printing out stocks with close less than opening value");
        List<StockEntry> closeLessThanOpen = db.getDatabase().stream().filter(stockEntry -> stockEntry.getClose() < stockEntry.getOpen()).collect(Collectors.toList());
        closeLessThanOpen.forEach(System.out::println);

    }



}
