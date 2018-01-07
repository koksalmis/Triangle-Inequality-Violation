package edu.advanceprogramming;
import org.paukov.combinatorics3.Generator;

import static edu.advanceprogramming.TurkishNetwork.cities;
import static edu.advanceprogramming.TurkishNetwork.distance;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String> cityList = Arrays.asList(cities);

    public static void main(String[] args) {

            Generator.combination(cities)
                    .simple(3)
                    .stream()
                    .filter(Main::isViolating)
                    .forEach(Main::printViolatingCities);

    }

    public static boolean isViolating(List<String> listOfCities) {

        int cityIndex1 = cityList.indexOf(listOfCities.get(0));
        int cityIndex2 = cityList.indexOf(listOfCities.get(1));
        int cityIndex3 = cityList.indexOf(listOfCities.get(2));

        int edgeA = distance[cityIndex1][cityIndex2];
        int edgeB = distance[cityIndex1][cityIndex3];
        int edgeC = distance[cityIndex2][cityIndex3];

        if( (edgeA + edgeB > edgeC) && (edgeA + edgeC > edgeB) && (edgeB + edgeC > edgeA) ) {
            return false;
        }else {
            return true;
        }
    }

    public static void printViolatingCities(List<String> violatingCities) {
        System.out.println(violatingCities.get(0) + ", " +violatingCities.get(1)+ ", " + violatingCities.get(2));
    }

}
