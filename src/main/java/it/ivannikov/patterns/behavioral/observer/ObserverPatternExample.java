package it.ivannikov.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/*
The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects
so that when one object changes state, all its dependents are notified and updated automatically.

Key Components
Subject (Observable) - Maintains a list of observers and notifies them of state changes

Observer - Interface that defines the update method for objects that should be notified

Concrete Observers - Implement the Observer interface and react to state changes
*
* */
public class ObserverPatternExample {

    public static void main(String[] args) {
        // Create subject
        WeatherStation weatherStation = new WeatherStation();

        // Create and register observers
        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
        TvDisplay tvDisplay = new TvDisplay(weatherStation);

        // Change weather and notify observers
        weatherStation.setTemperature(25.5f);
        weatherStation.setTemperature(30.2f);
    }

    // Subject (Observable)
    static class WeatherStation {
        private List<Observer> observers = new ArrayList<>();
        private float temperature;

        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(temperature);
            }
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
            notifyObservers();
        }
    }

    // Observer interface
    interface Observer {
        void update(float temperature);
    }

    // Concrete Observer 1
    static class PhoneDisplay implements Observer {
        public PhoneDisplay(WeatherStation weatherStation) {
            weatherStation.addObserver(this);
        }

        @Override
        public void update(float temperature) {
            System.out.println("Phone Display: Temperature updated to " + temperature + "°C");
        }
    }

    // Concrete Observer 2
    static class TvDisplay implements Observer {
        public TvDisplay(WeatherStation weatherStation) {
            weatherStation.addObserver(this);
        }

        @Override
        public void update(float temperature) {
            System.out.println("TV Display: Current temperature is " + temperature + "°C");
        }
    }
}