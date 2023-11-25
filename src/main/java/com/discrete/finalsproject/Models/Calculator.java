package com.discrete.finalsproject.Models;

import java.util.ArrayList;

public class Calculator {
    private static ArrayList<Double> data;
    private static int numberOfData;
    private static double mean, sampleStandardDeviation, sampleVariance,
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
        // Set the value of mean
        // this.mean =
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
        // this.standardDeviation =
    }

    // Get standard deviation
    public double getStandardDeviation(){
        return sampleStandardDeviation;
    }

    // TODO: Calculate population variance - Nicole
    public static void calculatePopulationVariance(){
        // Set the value of population variance
        // this.populationVariance =
    }

    // Get population variance
    public double getPopulationVariance(){
        return populationVariance;
    }

    // TODO: Calculate population standard deviation - Nicole
    public static void calculatePopulationStandardDeviation(){
        // Set the value of population standard deviation
        // this.populationStandardDeviation =
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

    }

    // Get x minus mean
    public ArrayList<Double> getXMinusMean(){
        return xMinusMean;
    }

    // TODO: calculate X minus mean squared - Leo
    public static void calculateXMinusMeanSquared(){
        // Set the value of x minus mean squared
        // this.xMinusMeanSquared =
    }

    // Get x minus mean squared
    public static ArrayList<Double> getXMinusMeanSquared(){
        return xMinusMeanSquared;
    }
}
