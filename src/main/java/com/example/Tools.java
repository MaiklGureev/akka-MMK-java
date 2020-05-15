package com.example;

public class Tools {
    private  double totalSum, devSum, lightersSum;

    private  Device[] devices = new Device[13];
    private  Room[] rooms = new Room[5];

    private  int countDays = 30;

    public  double minPowerConsumptionDayLimit = 300;
    public  double maxPowerConsumptionDayLimit = 350;

    public  int countTests = 5;

    void setDevicesValues() {
        devices[0] = new Device("Холодильник", 0.05, 24, 24, 1);
        devices[1] = new Device("Телевизор", 0.06, 2, 4.5, 2);
        devices[2] = new Device("СВЧ", 1.5, 0, 0.25, 1);
        devices[3] = new Device("Эл.духовка", 2, 0.5, 1, 1);
        devices[4] = new Device("Эл.чайник", 1.85, 0, 0.15, 1);
        devices[5] = new Device("Комп", 0.4, 1, 6, 1);
        devices[6] = new Device("Утюг", 1.8, 0, 0.25, 1);
        devices[7] = new Device("Посуд.маш.", 1.5, 0.5, 0.25, 1);
        devices[8] = new Device("Водонаргев.", 1.8, 0.5, 1.2, 1);
        devices[9] = new Device("Стирал.маш.", 1.2, 0.5, 1, 1);
        devices[10] = new Device("Зарядники", 0.015, 3, 4, 4);
        devices[11] = new Device("Фен", 1, 0, 0.25, 1);
        devices[12] = new Device("Пылесос", 1, 0, 0.1, 1);
    }

    void setRoomsValues() {
        rooms[0] = new Room("Ванная", 1, 2, 0.04, 2, 4);
        rooms[1] = new Room("Кухня", 1, 1, 0.06, 3, 6);
        rooms[2] = new Room("Гостинная", 1, 2, 0.06, 3, 6);
        rooms[3] = new Room("Спальня", 2, 2, 0.06, 0.5, 1);
        rooms[4] = new Room("Коридор", 1, 1, 0.04, 0.3, 0.5);
    }

     double powerConsumptionSum() {
        //приборы
        devSum = 0;
        for (int i = 0; i < devices.length; i++) {
            devSum += devices[i].getRandomPowerConsumption();
        }

        //освещение
        lightersSum = 0;
        for (int i = 0; i < rooms.length; i++) {
            lightersSum += rooms[i].getRandomPowerConsumption();
        }

        totalSum = devSum + lightersSum;

        totalSum = Math.round(totalSum * 100.0 * countDays) / 100.0;
        devSum = Math.round(devSum * 100.0 * devSum) / 100.0;
        lightersSum = Math.round(lightersSum * 100.0 * countDays) / 100.0;

        return totalSum;
    }


     double minPowerConsumptionSum() {
        //приборы
        devSum = 0;
        for (int i = 0; i < devices.length; i++) {
            devSum += devices[i].getMinPowerConsumption();
        }

        //освещение
        lightersSum = 0;
        for (int i = 0; i < rooms.length; i++) {
            lightersSum += rooms[i].getMinRandomPowerConsumption();
        }

        totalSum = devSum + lightersSum;
        totalSum = Math.round(totalSum * 100.0 * countDays) / 100.0;
        devSum = Math.round(devSum * 100.0 * countDays) / 100.0;
        lightersSum = Math.round(lightersSum * 100.0 * countDays) / 100.0;
        return totalSum;
    }

     double maxPowerConsumptionSum() {
        //приборы
        devSum = 0;
        for (int i = 0; i < devices.length; i++) {
            devSum += devices[i].getMaxPowerConsumption();
        }

        //освещение
        lightersSum = 0;
        for (int i = 0; i < rooms.length; i++) {
            lightersSum += rooms[i].getMaxRandomPowerConsumption();
        }


        totalSum = devSum + lightersSum;

        totalSum = Math.round(totalSum * 100.0 * countDays) / 100.0;
        devSum = Math.round(devSum * 100.0 * countDays) / 100.0;
        lightersSum = Math.round(lightersSum * 100.0 * countDays) / 100.0;

        return totalSum;
    }

     void printFlatConfiguration() {

        System.out.println("Приборы:");
        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i].getNameDevice()+ "(" + devices[i].getCurCountDevices() +")" + " --- "  +
                    " время раб.:" + devices[i].getCurrentTime());
        }
        System.out.println("Всего эл. потребл. приборов:" + devSum);
        System.out.println("Освещение:");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(rooms[i].getNameRoom()+ "(" + rooms[i].getCountRooms() +")" + " --- " + " кол-во ламп.:" +
                    rooms[i].getCountLighters() + " время раб.:" + rooms[i].getCurrentTime());
        }
        System.out.println("Всего эл. потребл. освещения:" + lightersSum);
        System.out.println("Суммарное эл. потребл. квартиры:" + totalSum);
    }

    public void doMMK(){
//        setDevicesValues();
//        setRoomsValues();
//        for (int a = 0; a < countTests; a++) {
//            powerConsumptionSum();
//            if (minPowerConsumptionDayLimit <= powerConsumptionSum() && maxPowerConsumptionDayLimit >= powerConsumptionSum()) {
//                System.out.println("-----Конфигурация №" + a + "-----");
//                printFlatConfiguration();
//                System.out.println();
//            }
//        }
//        System.out.println("-----Минимальная конфигурация-----");
//        minPowerConsumptionSum();
//        printFlatConfiguration();
//        System.out.println();
//        System.out.println("-----Максимальная конфигурация-----");
//        maxPowerConsumptionSum();
//        printFlatConfiguration();
    }

    public void generateAndPrintValues(int a, String worker){
        powerConsumptionSum();
        if (minPowerConsumptionDayLimit <= powerConsumptionSum() && maxPowerConsumptionDayLimit >= powerConsumptionSum()) {
            System.out.println("---"+worker+"---");
            System.out.println("-----Конфигурация №" + a + "-----");
            printFlatConfiguration();
            System.out.println();
       }
    }
}
