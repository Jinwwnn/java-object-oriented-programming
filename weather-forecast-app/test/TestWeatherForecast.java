import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weather.WeatherForecast;

/**
 * These are the unit tests for WeatherForecast class.
 */
public class TestWeatherForecast {
  private WeatherForecast week1;
  private WeatherForecast week2;
  private WeatherForecast week3;
  private WeatherForecast week4;
  private WeatherForecast boundaryWeek1;
  private WeatherForecast boundaryWeek2;

  /**
   * Set up data for the test cases.
   * Use all week data week1 to week 4 to test all method in WeatherForecast class.
   * Add boundaryWeek data boundaryWeek1 and boundaryWeek2 to test the last two methods.
   */
  @Before
  public void setUp() {
    week1 = new WeatherForecast(21.30f, 24.77f,
        29.5f, 27.3f, 25.05f,
        26.45f, 30.6f);
    week2 = new WeatherForecast(13.53f, 15.77f,
        12.9f, 12f, 14.89f,
        15.9f, 14.6f);
    week3 = new WeatherForecast(-10.0f, -8.0f,
        -5.0f, -3.0f, -2.0f,
        0.0f, 2.0f);
    week4 = new WeatherForecast(18.0f, 20.0f,
        22.0f, 23.0f, 24.0f,
        25.0f, 25.0f);
    // Boundary cases for average temperatures exactly 15°C and 25°C
    boundaryWeek1 = new WeatherForecast(15.0f, 15.0f,
        15.0f, 15.0f, 15.0f,
        15.0f, 15.0f);
    boundaryWeek2 = new WeatherForecast(25.0f, 25.0f,
        25.0f, 25.0f, 25.0f,
        25.0f, 25.0f);

  }

  /**
   * Test if calculateAverageTemperatureInCelsius() works as expected.
   */
  @Test
  public void testCalculateAverageTemperatureInCelsius() {
    assertEquals(26.42f, this.week1.calculateAverageTemperatureInCelsius(), 0.001);
    assertEquals(14.23f, this.week2.calculateAverageTemperatureInCelsius(), 0.001);
    assertEquals(-3.71f, this.week3.calculateAverageTemperatureInCelsius(), 0.001);
    assertEquals(22.43f, this.week4.calculateAverageTemperatureInCelsius(), 0.001);
  }

  /**
   * Test if calculateAverageTemperatureInFahrenheit() works as expected.
   */
  @Test
  public void testCalculateAverageTemperatureInFahrenheit() {
    assertEquals(79.56f, this.week1.calculateAverageTemperatureInFahrenheit(), 0.001);
    assertEquals(57.61f, this.week2.calculateAverageTemperatureInFahrenheit(), 0.001);
    assertEquals(25.31f, this.week3.calculateAverageTemperatureInFahrenheit(), 0.001);
    assertEquals(72.37f, this.week4.calculateAverageTemperatureInFahrenheit(), 0.001);
  }

  /**
   * Test if calculateMaxFluctuationInCelsius() works as expected.
   */
  @Test
  public void testCalculateMaxFluctuationInCelsius() {
    assertEquals(4.73f, this.week1.calculateMaxFluctuationInCelsius(), 0.001);
    assertEquals(2.89f, this.week2.calculateMaxFluctuationInCelsius(), 0.001);
    assertEquals(3.0f, this.week3.calculateMaxFluctuationInCelsius(), 0.001);
    assertEquals(2.0f, this.week4.calculateMaxFluctuationInCelsius(), 0.001);
  }

  /**
   * Test if calculateMaxFluctuationInFahrenheit() works as expected.
   */
  @Test
  public void testCalculateMaxFluctuationInFahrenheit() {
    assertEquals(8.51f, this.week1.calculateMaxFluctuationInFahrenheit(), 0.001);
    assertEquals(5.20f, this.week2.calculateMaxFluctuationInFahrenheit(), 0.001);
    assertEquals(5.40f, this.week3.calculateMaxFluctuationInFahrenheit(), 0.001);
    assertEquals(3.60f, this.week4.calculateMaxFluctuationInFahrenheit(), 0.001);
  }

  /**
   * Test if generateForecast() works as expected in several different conditions.
   */
  @Test
  public void testGenerateForecast() {
    assertEquals("Warm weather. Stay hydrated.", this.week1.generateForecast());
    assertEquals("Generally cool. Dress in layers.", this.week2.generateForecast());
    assertEquals("High risk of frost. Take precautions.", this.week3.generateForecast());
    assertEquals("Mild conditions. Enjoy outdoor activities.",
        this.week4.generateForecast());
    assertEquals("Generally cool. Dress in layers.", this.boundaryWeek1.generateForecast());
    assertEquals("Mild conditions. Enjoy outdoor activities.",
        this.boundaryWeek2.generateForecast());
  }

  /**
   * Test if toString() works as expected.
   */

  @Test
  public void testToString() {
    assertEquals("""
        Average temperature: 26.42°C, 79.56°F
        Max fluctuation: 4.73°C, 8.51°F
        Forecast: Warm weather. Stay hydrated.""", this.week1.toString());
    assertEquals("""
        Average temperature: 14.23°C, 57.61°F
        Max fluctuation: 2.89°C, 5.20°F
        Forecast: Generally cool. Dress in layers.""", this.week2.toString());
    assertEquals("""
        Average temperature: -3.71°C, 25.31°F
        Max fluctuation: 3.00°C, 5.40°F
        Forecast: High risk of frost. Take precautions.""", this.week3.toString());
    assertEquals("""
        Average temperature: 22.43°C, 72.37°F
        Max fluctuation: 2.00°C, 3.60°F
        Forecast: Mild conditions. Enjoy outdoor activities.""", this.week4.toString());
    assertEquals("""
        Average temperature: 15.00°C, 59.00°F
        Max fluctuation: 0.00°C, 0.00°F
        Forecast: Generally cool. Dress in layers.""", this.boundaryWeek1.toString());
    assertEquals("""
        Average temperature: 25.00°C, 77.00°F
        Max fluctuation: 0.00°C, 0.00°F
        Forecast: Mild conditions. Enjoy outdoor activities.""", this.boundaryWeek2.toString());
  }
}
