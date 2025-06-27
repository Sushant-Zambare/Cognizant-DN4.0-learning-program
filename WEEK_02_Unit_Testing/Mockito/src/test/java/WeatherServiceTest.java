import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {
    // Exercise - 01 (Mocking and Stubbing)
    @Test
    public void testExternalApi() {
        WeatherApi mockApi = Mockito.mock(WeatherApi.class);
        when(mockApi.getCurrentTemperature("Pune")).thenReturn("30°C");
        WeatherService service = new WeatherService(mockApi);
        String result = service.fetchTemperature("Pune");
        assertEquals("30°C", result);
    }

    // Exercise - 02 (Verifying Interactions)
    @Test
    public void testVerifyTemperatureCall() {
        WeatherApi mockApi = Mockito.mock(WeatherApi.class);
        WeatherService service = new WeatherService(mockApi);
        service.fetchTemperature("Delhi");
        verify(mockApi).getCurrentTemperature("Delhi");
    }
}
