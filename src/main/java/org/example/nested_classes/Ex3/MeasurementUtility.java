package org.example.nested_classes.Ex3;

public class MeasurementUtility {

    static class Converstion {

        public static double celsiusesToFahrenheit(double celsius) {
            return (celsius * 1.8) + 32;
        }

        public static double farenheightToCelsius(double farenheight) {
            return (farenheight - 32) / 1.8;
        }

        public static double kilometersToMiles(double kilometers) {
            return kilometers * 1.609344;
        }

        public static double milesToKilometers(double miles) {
            return miles / 1.609344;
        }

    }

    public static void main(String[] args) {

        System.out.println(Converstion.farenheightToCelsius(Converstion.celsiusesToFahrenheit(10)));
        System.out.println(Converstion.kilometersToMiles(Converstion.milesToKilometers(1)));
    }

}
