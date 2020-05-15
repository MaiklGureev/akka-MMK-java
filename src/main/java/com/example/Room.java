package com.example;

public class Room {

    private int countRooms;             //число комнат
    private int countLighters;          //число лампочек
    private double lighterPower;        //мощность лампочки
    private String nameRoom;           //название комнаты

    private double timeMin;
    private double timeMax;
    private double currentTime;

    private double powerConsumption;

    public Room(String nameRoom, int countRooms, int countLighters, double lighterPower, double timeMin, double timeMax) {
        this.nameRoom = nameRoom;
        this.countRooms = countRooms;
        this.countLighters = countLighters;
        this.lighterPower = lighterPower;
        this.timeMin = timeMin;
        this.timeMax = timeMax;
    }

    double getRandomPowerConsumption() {
        currentTime = timeMin + Math.random() * (timeMax - timeMin);    //генерируем время
        currentTime = Math.round(currentTime * 100.0) / 100.0;       //округляем
        powerConsumption = currentTime * countLighters * countRooms * lighterPower; //перемножаем
        powerConsumption = Math.round(powerConsumption * 100.0) / 100.0; //округляем результат
        return powerConsumption;
    }

    double getMinRandomPowerConsumption() {
        currentTime = timeMin;    //генерируем время
        currentTime = Math.round(currentTime * 100.0) / 100.0;       //округляем
        powerConsumption = currentTime * countLighters * countRooms * lighterPower; //перемножаем
        powerConsumption = Math.round(powerConsumption * 100.0) / 100.0; //округляем результат
        return powerConsumption;
    }

    double getMaxRandomPowerConsumption() {
        currentTime = timeMax;    //генерируем время
        currentTime = Math.round(currentTime * 100.0) / 100.0;       //округляем
        powerConsumption = currentTime * countLighters * countRooms * lighterPower; //перемножаем
        powerConsumption = Math.round(powerConsumption * 100.0) / 100.0; //округляем результат
        return powerConsumption;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public int getCountLighters() {
        return countLighters;
    }

    public double getCurrentTime() {
        return currentTime;
    }
}
