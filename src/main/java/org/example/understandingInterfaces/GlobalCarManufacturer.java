package org.example.understandingInterfaces;
@FunctionalInterface
public interface GlobalCarManufacturer {

    public abstract void makeFerrariCar();

    //public abstract void makeBensCar();



    default int requestingWheelsCount(){
        return 4;
    }}

