package com.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.util.Timeout;

import java.util.concurrent.CompletableFuture;


import static akka.pattern.PatternsCS.ask;


public class MainWorkerActor extends AbstractActor {

    ActorRef actorRef1;
    ActorRef actorRef2;


    public MainWorkerActor() {
        actorRef1 = getContext().actorOf(
                WorkerBotActor.props("worker1", 500));
        actorRef2 = getContext().actorOf(
                WorkerBotActor.props("worker2", 500));
    }

    public AbstractActor.Receive createReceive() {
        return receiveBuilder().matchEquals("start", p -> {

            CompletableFuture<Object> future1 = ask(actorRef1,
                    "do", 999999).toCompletableFuture();
            CompletableFuture<Object> future2 = ask(actorRef2,
                    "do", 999999).toCompletableFuture();

            CompletableFuture.allOf(future1, future2)
                    .thenApply(
                            v -> {
                                if (future1.isDone() && future2.isDone()) {
                                    getContext().getSystem().stop(getContext().getParent());
                                    System.out.println("OVER!");
                                    return true;
                                } else {
                                    getContext().getSystem().stop(getContext().getParent());
                                    System.out.println("OVER WITH ERROR.TIMEOUT.");
                                    return false;
                                }
                            });


        }).build();
    }


}
