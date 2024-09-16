package weather;

/**
 * A class to do weather forecasting. It calculates the average temperature for the week, the
 * maximum fluctuation in temperature for the week, and generates a weather forecast based on the
 * average temperature. Results are provided in both Celsius and Fahrenheit.
 */
public class WeatherForecast {
  private final float[] dailyTemperatures; // An array to store daily temperatures in a week.

  /**
   * The constructor of the WeatherForecast class. Initialize the dailyTemperature array.
   *
   * @param sundayTemperature    the temperature of Sunday in Celsius
   * @param mondayTemperature    the temperature of Monday in Celsius
   * @param tuesdayTemperature   the temperature of Tuesday in Celsius
   * @param wednesdayTemperature the temperature of Wednesday in Celsius
   * @param thursdayTemperature  the temperature of Thursday in Celsius
   * @param fridayTemperature    the temperature of Friday in Celsius
   * @param saturdayTemperature  the temperature of Saturday in Celsius
   */
  public WeatherForecast(float sundayTemperature, float mondayTemperature, float tuesdayTemperature,
                         float wednesdayTemperature, float thursdayTemperature,
                         float fridayTemperature, float saturdayTemperature) {
    this.dailyTemperatures = new float[] {sundayTemperature, mondayTemperature, tuesdayTemperature,
        wednesdayTemperature, thursdayTemperature, fridayTemperature, saturdayTemperature};
  }

  /**
   * Help convert the temperature in Celsius to Fahrenheit.
   *
   * @param temperature the temperature in Celsius
   *
   * @return temperature in Fahrenheit
   */
  private float convertToFahrenheit(float temperature) {
    return (temperature * 9) / 5 + 32;
  }

  /**
   * Help round a float to two decimal places.
   *
   * @param number a float number
   *
   * @return a float with two decimal places
   */
  private float roundTwoDecimals(float number) {
    return Math.round(number * 100) / 100.0f;
  }

  /**
   * Calculates the average temperature for the week in degrees Celsius. The result is rounded to
   * two decimal places.
   *
   * @return the average temperature for the week
   */
  public float calculateAverageTemperatureInCelsius() {
    float sumTemperature = 0;
    for (float temperature : dailyTemperatures) {
      sumTemperature += temperature;
    }
    return roundTwoDecimals(sumTemperature / dailyTemperatures.length);
  }

  /**
   * Calculates the average temperature for the week in degrees Fahrenheit. The result is rounded to
   * two decimal places.
   *
   * @return the average temperature for the week
   */
  public float calculateAverageTemperatureInFahrenheit() {
    float sumTemperatureInFahrenheit = 0;
    // Convert temperature in Celsius to Fahrenheit then get the sum.
    for (float temperature : dailyTemperatures) {
      temperature = convertToFahrenheit(temperature);
      sumTemperatureInFahrenheit += temperature;
    }
    return roundTwoDecimals(sumTemperatureInFahrenheit / dailyTemperatures.length);
  }

  /**
   * Calculates the maximum fluctuation in temperature for the week in degrees Celsius. The
   * fluctuation is the difference between the highest and lowest temperatures for two consecutive
   * days. The result is rounded to two decimal places.
   *
   * @return the maximum fluctuation in temperature for the week
   */
  public float calculateMaxFluctuationInCelsius() {
    float maxFluctuation = 0;
    for (int i = 1; i < dailyTemperatures.length; i++) {
      float fluctuation = Math.abs(dailyTemperatures[i] - dailyTemperatures[i - 1]);
      maxFluctuation = Math.max(maxFluctuation, fluctuation);
    }
    return roundTwoDecimals(maxFluctuation);
  }

  /**
   * Calculates the maximum fluctuation in temperature for the week in degrees Fahrenheit. The
   * fluctuation is the difference between the highest and lowest temperatures for two consecutive
   * days. The result is rounded to two decimal places.
   *
   * @return the maximum fluctuation in temperature for the week
   */
  public float calculateMaxFluctuationInFahrenheit() {
    float maxFluctuationInFahrenheit = 0;
    // Convert all temperatures in dailyTemperatures into Fahrenheit, then find the max fluctuation.
    dailyTemperatures[0] = convertToFahrenheit(dailyTemperatures[0]);
    for (int i = 1; i < dailyTemperatures.length; i++) {
      dailyTemperatures[i] = convertToFahrenheit(dailyTemperatures[i]);
      float fluctuation = Math.abs(dailyTemperatures[i] - dailyTemperatures[i - 1]);
      maxFluctuationInFahrenheit = Math.max(maxFluctuationInFahrenheit, fluctuation);
    }
    return roundTwoDecimals(maxFluctuationInFahrenheit);
  }

  /**
   * Generates a weather forecast based on the average temperature for the week.
   *
   * @return a weather forecast message
   */
  public String generateForecast() {
    float averageTemperatureInCelsius = calculateAverageTemperatureInCelsius();
    if (averageTemperatureInCelsius < 0) {
      return "High risk of frost. Take precautions.";
    } else if (averageTemperatureInCelsius <= 15) {
      return "Generally cool. Dress in layers.";
    } else if (averageTemperatureInCelsius <= 25) {
      return "Mild conditions. Enjoy outdoor activities.";
    } else {
      return "Warm weather. Stay hydrated.";
    }
  }

  /**
   * Generate a string include all weather information in this class.
   *
   * @return a string include all weather information in this class
   */
  @Override
  public String toString() {
    String forecastMessage = generateForecast();
    return String.format("Average temperature: %.2f°C, %.2f°F\nMax fluctuation: %.2f°C, %.2f°F\n"
            + "Forecast: %s",
        calculateAverageTemperatureInCelsius(),
        calculateAverageTemperatureInFahrenheit(),
        calculateMaxFluctuationInCelsius(),
        calculateMaxFluctuationInFahrenheit(),
        forecastMessage);
  }
}