import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;
/*******************************************
 * Class to test the StockDatabase
 *
 * @author - Resendiz
 * @version - 1.0.0 - October 2021
 ******************************************/
public class StockDatabaseJUnit{
    /** object of the StockDatabase class */
    private StockDatabase database;

    /******************************************************
     * Test constructor
     *****************************************************/
    @Test
    public void testConstructor()
    {
        database = new StockDatabase();
        assertEquals("ArrayList should not contain any records at this time",
                0, database.countRecords ());
    }

    /******************************************************
     * Test read file and counts
     *****************************************************/
    @Test
    public void testReadFileAndCounts()
    {
        database= new StockDatabase();
        database.readStockData("data/stock_data.csv");
        assertEquals("ArrayList should contain 61 records",
                61, database.countRecords ());
    }
}

