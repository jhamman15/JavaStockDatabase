import static org.junit.Assert.*;
import org.junit.*;
/*******************************************
 * Class to test the Stock Entry class
 *
 ******************************************/

public class StockEntryJUnit {
    /** object of the Stock Entry class*/
    private StockEntry s;

    /******************************************************
     * Test constructor
     *****************************************************/
    @Test
    public void testConstructor()  {
        //Testing a Stock Entry
        s = new StockEntry("04/01/21",15.50,17.50,14.50,16.50);

        assertEquals("Constructor: Date should be equal to value of input parameter",
                "04/01/21", s.getDate());

        assertEquals("Constructor: open should be equal to value of input parameter",
                15.50, s.getOpen(), 0.1);

        assertEquals("Constructor: high should be equal to value of input parameter",
                17.50, s.getHigh(), 0.1);

        assertEquals("Constructor: low should be equal to value of input parameter",
                14.50, s.getLow(), 0.1);

        assertEquals("Constructor: close should be equal to value of input parameter",
                16.50, s.getClose(), 0.1);

    }
}