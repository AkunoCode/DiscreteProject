package com.discrete.finalsproject.Models;

import java.util.ArrayList;

public class Calculator {
    private Calculator() {}
    private static ArrayList<Double> data;
    private static int numberOfData;
    private static double mean;
    private static double sampleStandardDeviation;
    private static double sampleVariance;
    private static double sumOfXMinusMeanSquared;
    private static double populationStandardDeviation;
    private static double populationVariance;
    private static ArrayList<Double> xMinusMean, xMinusMeanSquared;

    public static void setData(ArrayList<Double> inputData){
        data = inputData;
        numberOfData = data.size();
    }
    public static ArrayList<Double> getData(){
        return data;
    }
    public static int getNumberOfData(){
        return numberOfData;
    }

    // Calculate Mean
    public static void calculateMean(){
        double sumOfData = 0.0;
        for (Double d : data) {
            sumOfData += d;
        }
        mean = sumOfData / numberOfData;
    }

    // Get mean
    public static double getMean(){
        return mean;
    }

    public static void calculateVariance(){
        sampleVariance = getSumOfXMinusMeanSquared() / (data.size() - 1);
    }

    // Get variance
    public static double getVariance(){
        return sampleVariance;
    }

    // Calculate standard deviation
    public static void calculateStandardDeviation(){
        sampleStandardDeviation = Math.sqrt(sampleVariance);
    }

    // Get standard deviation
    public static double getStandardDeviation(){
        return sampleStandardDeviation;
    }

    // Calculate population variance
    public static void calculatePopulationVariance(){
        populationVariance = getSumOfXMinusMeanSquared() / numberOfData;
    }

    // Get population variance
    public static double getPopulationVariance(){
        return populationVariance;
    }

    // Calculate population standard deviation
    public static void calculatePopulationStandardDeviation(){
        populationStandardDeviation = Math.sqrt(populationVariance);
    }

    // Get population standard deviation
    public static double getPopulationStandardDeviation(){
        return populationStandardDeviation;
    }

    public static void calculateSumOfXMinusMeanSquared(){
        // Set the value of sum of x minus mean squared
        sumOfXMinusMeanSquared = 0;
        for (Double XminusMeanSquared: xMinusMeanSquared) {
            sumOfXMinusMeanSquared += XminusMeanSquared;
        }
    }

    // Get sum of x minus mean squared
    public static double getSumOfXMinusMeanSquared(){
        return sumOfXMinusMeanSquared;
    }

    // Calculate x minus mean
    public static void calculateXMinusMean(){
        xMinusMean = new ArrayList<>();
        for (Double d : data) {
            xMinusMean.add(d - mean);
        }
    }

    // Get x minus mean
    public ArrayList<Double> getXMinusMean(){
        return xMinusMean;
    }

    // Calculate x minus mean squared
    public static void calculateXMinusMeanSquared(){
        xMinusMeanSquared = new ArrayList<>();
        for (Double d : xMinusMean) {
            xMinusMeanSquared.add(Math.pow(d, 2));
        }
    }

    // Get x minus mean squared
    public static ArrayList<Double> getXMinusMeanSquared(){
        return xMinusMeanSquared;
    }

    // Calculate all for sample
    public static void calculateAllForSample(){
        calculateMean();
        calculateXMinusMean();
        calculateXMinusMeanSquared();
        calculateSumOfXMinusMeanSquared();
        calculateVariance();
        calculateStandardDeviation();
    }

    // Calculate all for population
    public static void calculateAllForPopulation(){
        calculateMean();
        calculateXMinusMean();
        calculateXMinusMeanSquared();
        calculateSumOfXMinusMeanSquared();
        calculatePopulationVariance();
        calculatePopulationStandardDeviation();
    }
}
