import java.text.DecimalFormat;

public class TemperatureConverter {

    public double fahrenheitToCelsius(double fahrenheit) {
        DecimalFormat df = new DecimalFormat("#.#");

        return Double.parseDouble(df.format((fahrenheit - 32) * 5 / 9));
    }

    public double celsiusToFahrenheit(double celcius) {
        DecimalFormat df = new DecimalFormat("#.#");

        return Double.parseDouble(df.format(celcius * 9 / 5 + 32));
    }

    public double kelvinToCelcius(int kelvin) {
        DecimalFormat df = new DecimalFormat("#.#");

        return Double.parseDouble(df.format(((kelvin - 273.15) * 100.0) / 100.0));
    }

    public boolean isExtremeTemperature(double temperatureC) {
        if (temperatureC < -40) {
            return true;
        } else if (temperatureC > 50) {
            return true;
        } else {
            return false;
        }
    }

}
