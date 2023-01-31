package com.estudo.megasema.controller;

import com.estudo.megasema.dto.jogos.JogoAleatorioDto;
import com.estudo.megasema.service.JogosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aleatorio")
@RequiredArgsConstructor
public class JogoAleatorioController {

    private final JogosService jogosService;
    @GetMapping
    public ResponseEntity<JogoAleatorioDto> gerarNumeroAleatorio(){
        var numeros = jogosService.gerarNumeroAleatorio();

        return new ResponseEntity<>(numeros, HttpStatus.OK);
    }
}
