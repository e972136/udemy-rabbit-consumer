package com.udemy.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @RabbitListener(queues = {"${udemy.queue.name}"},ackMode = "NONE")
//    @RabbitListener(queues = {"${udemy.queue.name}"})
    public void receive(@Payload ObjetoIntercambio message){
        log.info("Recibiendo {}",message);
        makeSlog();
    }

    private void makeSlog() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
