package com.github.search.controller;

import com.github.search.document.Airfare;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AirfareController {

    @GetMapping("/findAll")
    ResponseEntity<?> findAll();

    @GetMapping("/findId/{id}")
    ResponseEntity<?> findId(@PathVariable("id") String id);

    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody Airfare airfare);

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable("id") String id,@RequestBody Airfare t);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") String id);
}
