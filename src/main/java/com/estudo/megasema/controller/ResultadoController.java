package com.estudo.megasema.controller;

import com.estudo.megasema.service.ResultadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/resultado")
@RequiredArgsConstructor
public class ResultadoController {

    private final ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<String> teste(){
        resultadoService.salvarResultado();
        return ResponseEntity.ok("teste");
    }
}
