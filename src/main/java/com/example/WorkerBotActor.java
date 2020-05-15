package com.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class WorkerBotActor extends AbstractActor {

    private String text;
    private Tools tools;
    private int countExperiments;


    public WorkerBotActor(String text, int countExperiments) {
        this.text = text;
        this.countExperiments = countExperiments;
        tools = new Tools();
        tools.setDevicesValues();
        tools.setRoomsValues();
    }

    public static Props props(String text,int count) {
        return Props.create(WorkerBotActor.class, text,count);
    }

    public Receive createReceive() {
        return receiveBuilder().matchEquals("do", p -> {
           for(int a= 0; a<countExperiments;a++){
               tools.generateAndPrintValues(a,text);
           }
                getSender().tell("over",self());
        }).build();
    }
}
