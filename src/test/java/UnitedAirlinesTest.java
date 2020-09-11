import org.junit.Test;

public class UnitedAirlinesTest extends WebdriverParameters {

    @Test
    public void searchFlightTest() {
        // input parameters
        String fromAirportInput = "New York, NY, US (JFK)";
        String toAirportInput = "Miami, FL, US (MIA - All Airports)";
        String departDateInput = "OCT 01";
        boolean isOneWay = true;

        // test itself
        HomePage home = new HomePage();
        home.inputFlightData(fromAirportInput, toAirportInput, departDateInput, isOneWay);
        ResultPage resultPage = new ResultPage();
        resultPage.printResults();
    }
}