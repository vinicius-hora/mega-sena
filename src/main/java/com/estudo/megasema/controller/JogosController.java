package com.estudo.megasema.controller;

import com.estudo.megasema.dto.jogos.GetJogosDto;
import com.estudo.megasema.dto.jogos.JogosDto;
import com.estudo.megasema.service.JogosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jogo")
@RequiredArgsConstructor
@Tag(name = "JogosController")
public class JogosController {

    private final JogosService jogosService;

    @Operation(summary = "Lista todos os jogos salvos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista os jogos salvos com sucesso"),
    })
    @GetMapping()
    public ResponseEntity<List<GetJogosDto>> listarTodos(){
        var jogos = jogosService.listarTodos();

        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    @Operation(summary = "Salva um jogo informado pela pessoa", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogo Salvo com sucesso"),
    })
    @PostMapping
    public ResponseEntity<?> cadastrarJogo(@RequestBody JogosDto jogosDto){
        jogosService.salvar(jogosDto);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
