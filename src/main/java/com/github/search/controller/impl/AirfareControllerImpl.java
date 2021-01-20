package com.github.search.controller.impl;

import com.github.search.controller.AirfareController;
import com.github.search.document.Airfare;

import com.github.search.service.AirfareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.client.HttpClientErrorException.*;
import static org.springframework.web.client.HttpServerErrorException.*;

@RestController
@RequestMapping("/test")
public class AirfareControllerImpl implements AirfareController {
    @Autowired
    private AirfareServiceImpl service;

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<?> findId(String id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        }catch (NotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (MethodNotAllowed notAllowed){
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }catch(InternalServerError error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> save(Airfare airfare) {
        try {
            return new ResponseEntity<>(service.saveAirfare(airfare), HttpStatus.CREATED);
        }catch(NullPointerException exception){
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }catch (BadRequest badRequest) {
            return ResponseEntity.badRequest().build();
        }
        catch(InternalServerError error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> update(String id, Airfare t) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }catch (BadRequest badRequest){
            return ResponseEntity.badRequest().build();
        }catch(InternalServerError error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
