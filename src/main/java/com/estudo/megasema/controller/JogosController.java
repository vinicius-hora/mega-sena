package com.estudo.megasema.controller;

import com.estudo.megasema.dto.jogos.JogosDto;
import com.estudo.megasema.service.JogosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jogo")
@RequiredArgsConstructor
public class JogosController {

    private final JogosService jogosService;

    @GetMapping()
    public ResponseEntity<List<JogosDto>> listarTodos(){
        var jogos = jogosService.listarTodos();

        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarJogo(@RequestBody JogosDto jogosDto){
        jogosService.salvar(jogosDto);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
