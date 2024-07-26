package com.estudo.megasema.controller;

import com.estudo.megasema.dto.resultados.GetResuldatoDto;
import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.service.ResultadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ResultadoController")
public class ResultadoController {

    private final ResultadoService resultadoService;

    @Operation(summary = "Lista os resultados dos jogos salvos da mega-sena", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<GetResuldatoDto>> mostrarTodos(){
        List<GetResuldatoDto> resultadoDtoList = resultadoService.mostrarTodos();
        return ResponseEntity.ok(resultadoDtoList);
    }
}
