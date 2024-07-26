package com.estudo.megasema.controller;

import com.estudo.megasema.dto.jogos.JogoAleatorioDto;
import com.estudo.megasema.service.JogosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aleatorio")
@RequiredArgsConstructor
@Tag(name = "JogoAleatorioController")
public class JogoAleatorioController {

    private final JogosService jogosService;
    @Operation(summary = "Gera números aleatórios para um jogo da mega-sena", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Números gerados com sucesso"),
    })
    @GetMapping
    public ResponseEntity<JogoAleatorioDto> gerarNumeroAleatorio(){
        var numeros = jogosService.gerarNumeroAleatorio();

        return new ResponseEntity<>(numeros, HttpStatus.OK);
    }
}
