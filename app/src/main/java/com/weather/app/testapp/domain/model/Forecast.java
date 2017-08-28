package com.weather.app.testapp.domain.model;

import org.parceler.Parcel;

@Parcel
public class Forecast {

    int id;
    String name;
    String temperature;
    String pressure;
    String humidity;
    String main;
    String exact_date;
    String wind_speed;

    public Forecast() {
    }

    public Forecast(int id, String name, String temperature, String pressure, String humidity, String main) {

        this.id = id;
        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.main = main;

    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getExact_date() {
        return exact_date;
    }

    public void setExact_date(String exact_date) {
        this.exact_date = exact_date;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
