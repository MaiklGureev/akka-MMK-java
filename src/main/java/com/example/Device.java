package com.example;

public class Device {

    private double devicePower;         //мощность прибора
    private int maxCountDevices;        //количество приборов
    private  String nameDevice;         //название прибора

    private double timeMin;
    private double timeMax;
    private double currentTime;

    private int curCountDevices;

    private double powerConsumption;


    public Device(String nameDevice,double power, double timeMin,double timeMax, int maxCountDevices){
        this.nameDevice = nameDevice;
        this.devicePower = power;
        this.timeMin = timeMin;
        this.timeMax = timeMax;
        this.maxCountDevices = maxCountDevices;
    }

    double getRandomPowerConsumption(){
        currentTime = timeMin + Math.random()*(timeMax-timeMin);    //генерируем время
        currentTime =Math.round(currentTime * 100.0) / 100.0;       //округляем
        curCountDevices = 1 + (int) (Math.random() * maxCountDevices);  //генерируем колличество
        powerConsumption = currentTime * devicePower * maxCountDevices; //перемножаем
        powerConsumption =Math.round(powerConsumption * 100.0) / 100.0; //округляем результат
        return powerConsumption;
    }

    double getMinPowerConsumption(){
        currentTime = timeMin;
        currentTime = Math.round(currentTime * 100.0) / 100.0;
        curCountDevices = 1;
        powerConsumption = currentTime * devicePower * maxCountDevices;
        powerConsumption =Math.round(powerConsumption * 100.0) / 100.0;
        return powerConsumption;
    }

    double getMaxPowerConsumption(){
        currentTime = timeMax;
        currentTime =Math.round(currentTime * 100.0) / 100.0;
        curCountDevices = maxCountDevices;
        powerConsumption = currentTime * devicePower * maxCountDevices;
        powerConsumption =Math.round(powerConsumption * 100.0) / 100.0;
        return powerConsumption;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public int getCurCountDevices() {
        return curCountDevices;
    }

    public double getCurrentTime() {
        return currentTime;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }
}
