package com.example;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


public class Main {


    public static void main(String[] args) {
        // write your code here

        ActorSystem system = ActorSystem.create("test-system");

        ActorRef actorRef0 = system.actorOf(
                Props.create(MainWorkerActor.class));

        actorRef0.tell("start", ActorRef.noSender());


    }





}
