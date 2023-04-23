package lpd.rmi.data;

import java.io.Serializable;
import java.time.LocalDate;

public final class Weather implements Serializable {
    
    private static final long serialVersionUID = -2598374210122976147L;
    private LocalDate date;
    private String condition;
    private double temperature;

    public Weather(LocalDate date, String condition, double temperature) {
        this.date = date;
        this.condition = condition;
        this.temperature = temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCondition() {
        return condition;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Weather [date=" + date + ", condition=" + condition + ", temperature=" + temperature + "]";
    }
    
}
