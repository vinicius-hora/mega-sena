package com.estudo.megasema.controller;

import com.estudo.megasema.dto.resultados.GetResuldatoDto;
import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.service.ResultadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/resultado")
@RequiredArgsConstructor
public class ResultadoController {

    private final ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<List<GetResuldatoDto>> mostrarTodos(){
        List<GetResuldatoDto> resultadoDtoList = resultadoService.mostrarTodos();
        return ResponseEntity.ok(resultadoDtoList);
    }
}
