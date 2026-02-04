import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void fahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();

        assertEquals(55, converter.fahrenheitToCelsius(12.7));

        assertEquals(0, converter.fahrenheitToCelsius(32));

        assertEquals(-100, converter.fahrenheitToCelsius(-40));
    }

    @Test
    void celsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();

        assertEquals(14.0, converter.celsiusToFahrenheit(-10));

        assertEquals(32.0, converter.celsiusToFahrenheit(0));

        assertEquals(212.0, converter.celsiusToFahrenheit(100));
    }

    @Test
    void isExtremeTemperature() {
        TemperatureConverter converter = new TemperatureConverter();

        assertTrue(converter.isExtremeTemperature(-100));

        assertFalse(converter.isExtremeTemperature(100));
    }
}