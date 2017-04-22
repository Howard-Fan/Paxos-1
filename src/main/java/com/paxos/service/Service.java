package com.paxos.service;

import com.paxos.exception.DoesNotExistException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by hyh608 on 4/21/17.
 */
@Component
public class Service {

    ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();

    public String sha256Hash(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(message.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        map.put(sb.toString(), message);
        return sb.toString();
    }


    public String sha256Unhash(String hash) throws DoesNotExistException {
        if (map.containsKey(hash)) {
            return map.get(hash);
        } else {
            throw new DoesNotExistException(hash);
        }
    }
}
