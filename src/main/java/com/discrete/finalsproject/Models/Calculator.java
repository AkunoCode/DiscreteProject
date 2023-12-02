package com.discrete.finalsproject.Models;

import java.util.ArrayList;

public class Calculator {
    private static ArrayList<Double> data;
    private static int numberOfData;
    private static double sumOfData, mean, sampleStandardDeviation, sampleVariance,
            sumOfXMinusMeanSquared, populationStandardDeviation, populationVariance;
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

    // TODO: Calculate mean - Nicole
    public static void calculateMean(){
        sumOfData = 0.0;
        for (Double d : data) {
            sumOfData += d;
        }
        mean = sumOfData / numberOfData;
    }

    // Get mean
    public double getMean(){
        return mean;
    }

    // TODO: Calculate sample variance - Adrielle
    public static void calculateVariance(){
        // Set the value of variance
        // this.variance =
    }

    // Get variance
    public double getVariance(){
        return sampleVariance;
    }

    // TODO: Calculate sample standard deviation - Adrielle
    public static void calculateStandardDeviation(){
        // Set the value of standard deviation

    }

    // Get standard deviation
    public double getStandardDeviation(){
        return sampleStandardDeviation;
    }

    // TODO: Calculate population variance - Nicole
    public static void calculatePopulationVariance(){
        ArrayList<Double> xMinusMeanSquared = getXMinusMeanSquared();
        sumOfXMinusMeanSquared = 0.0;
        for (Double squaredValue : xMinusMeanSquared) {
            sumOfXMinusMeanSquared += squaredValue;
        }
        populationVariance = sumOfXMinusMeanSquared / numberOfData;
    }

    // Get population variance
    public double getPopulationVariance(){
        return populationVariance;
    }

    // TODO: Calculate population standard deviation - Nicole
    public static void calculatePopulationStandardDeviation(){
        calculatePopulationVariance();
        populationStandardDeviation = Math.sqrt(populationVariance);
    }

    // Get population standard deviation
    public double getPopulationStandardDeviation(){
        return populationStandardDeviation;
    }

    // TODO: Calculate sum of x minus mean squared - Johann
    public static void calculateSumOfXMinusMeanSquared(){
        // Set the value of sum of x minus mean squared
        // this.sumOfXMinusMeanSquared =
    }

    // Get sum of x minus mean squared
    public double getSumOfXMinusMeanSquared(){
        return sumOfXMinusMeanSquared;
    }

    // TODO: caclulate X minus mean - Leo
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

    // TODO: calculate X minus mean squared - Leo
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
}
