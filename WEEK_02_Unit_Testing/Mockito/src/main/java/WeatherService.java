public class WeatherService {
    private final WeatherApi weatherApi;

    public WeatherService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public String fetchTemperature(String city) {
        return weatherApi.getCurrentTemperature(city);
    }
}
