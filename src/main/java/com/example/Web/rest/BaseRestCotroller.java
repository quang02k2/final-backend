package com.example.Web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class BaseRestCotroller {
    public ResponseEntity<Map<String,Object >> success(Object data){
        Map<String, Object> responit = new HashMap<>();
        responit.put("code",200);
        responit.put("message", "Oke");
        responit.put("data", data);
        return new ResponseEntity<Map<String,Object>>(responit, HttpStatus.OK);

}

    public ResponseEntity<Map<String,Object >> error(int code,String message){
        Map<String, Object> responit = new HashMap<>();
        responit.put("code",code);
        responit.put("message", message);
        responit.put("data", null);
        return new ResponseEntity<Map<String,Object>>(responit, HttpStatus.OK);

    }
}
