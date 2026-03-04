public class TempConverterMain {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println(converter.fahrenheitToCelsius(98.6) + " C");
        System.out.println(converter.celsiusToFahrenheit(37) + " F");
        System.out.println(converter.kelvinToCelcius(300) + " C");
        System.out.println(converter.isExtremeTemperature(-50));
    }
}
