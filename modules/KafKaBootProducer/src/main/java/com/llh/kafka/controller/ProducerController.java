/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.kafka.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AppDes
 */
@RestController
@RequestMapping("/api/producer")
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, HashMap<String, Object>> kafkaTemplate ;

    @RequestMapping(value = "/{mesage}", method = RequestMethod.GET)
    public HashMap<String, Object> getProducts(@PathVariable String mesage) {
        HashMap<String, Object> pro = new HashMap<String, Object>();
        pro.put("ID", 1);
        pro.put("MESAGE", mesage);
        sendMessage(pro);
        return pro;
    }

    public void sendMessage(HashMap<String, Object> msg) {
        kafkaTemplate.send("kafka-test", msg);
    }

}
