package com.discrete.finalsproject.Models;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Double> data;
    private int numberOfData;
    private double mean, sampleStandardDeviation, sampleVariance,
            sumOfXMinusMeanSquared, populationStandardDeviation, populationVariance;
    private ArrayList<Double> xMinusMean, xMinusMeanSquared;

    private void setData(ArrayList<Double> data){
        this.data = data;
        this.numberOfData = data.size();
    }
    private ArrayList<Double> getData(){
        return this.data;
    }
    private int getNumberOfData(){
        return this.numberOfData;
    }

    // TODO: Calculate mean - Nicole
    private void calculateMean(){
        // Set the value of mean
        // this.mean =
    }

    // Get mean
    public double getMean(){
        return this.mean;
    }

    // TODO: Calculate sample variance - Adrielle
    private void calculateVariance(){
        // Set the value of variance
        // this.variance =
    }

    // Get variance
    public double getVariance(){
        return this.sampleVariance;
    }

    // TODO: Calculate sample standard deviation - Adrielle
    private void calculateStandardDeviation(){
        // Set the value of standard deviation
        // this.standardDeviation =
    }

    // Get standard deviation
    public double getStandardDeviation(){
        return this.sampleStandardDeviation;
    }

    // TODO: Calculate population variance - Nicole
    private void calculatePopulationVariance(){
        // Set the value of population variance
        // this.populationVariance =
    }

    // Get population variance
    public double getPopulationVariance(){
        return this.populationVariance;
    }

    // TODO: Calculate population standard deviation - Nicole
    private void calculatePopulationStandardDeviation(){
        // Set the value of population standard deviation
        // this.populationStandardDeviation =
    }

    // Get population standard deviation
    public double getPopulationStandardDeviation(){
        return this.populationStandardDeviation;
    }

    // TODO: Calculate sum of x minus mean squared - Johann
    private void calculateSumOfXMinusMeanSquared(){
        // Set the value of sum of x minus mean squared
        // this.sumOfXMinusMeanSquared =
    }

    // Get sum of x minus mean squared
    public double getSumOfXMinusMeanSquared(){
        return this.sumOfXMinusMeanSquared;
    }

    // TODO: caclulate X minus mean - Leo
    private void calculateXMinusMean(){
        // Set the value of x minus mean
        // this.xMinusMean =
    }

    // Get x minus mean
    public ArrayList<Double> getXMinusMean(){
        return this.xMinusMean;
    }

    // TODO: calculate X minus mean squared - Leo
    private void calculateXMinusMeanSquared(){
        // Set the value of x minus mean squared
        // this.xMinusMeanSquared =
    }

    // Get x minus mean squared
    public ArrayList<Double> getXMinusMeanSquared(){
        return this.xMinusMeanSquared;
    }
}
