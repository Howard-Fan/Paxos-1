package com.paxos.controller;

import com.paxos.exception.DoesNotExistException;
import com.paxos.service.Service;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyh608 on 4/21/17.
 */

@RestController
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(method = RequestMethod.POST, path = "/messages", consumes = "application/json",produces = "application/json")
    public Map<String, String> hashMessage(@NotNull @RequestBody Map<String, Object> message) throws NoSuchAlgorithmException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("digest", service.sha256Hash(message.get("message").toString()));
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/messages/{hash}", produces = "application/json")
    public Map<String, String> unHashMessage(@PathVariable String hash) throws DoesNotExistException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", service.sha256Unhash(hash));
        return map;
    }
}
