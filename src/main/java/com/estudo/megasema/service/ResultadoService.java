package com.estudo.megasema.service;

import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.model.Resultado;
import com.estudo.megasema.repository.ResultadoRepository;
import com.estudo.megasema.repository.feingRepository.ResultadoFeingRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResultadoService {
    private final ResultadoFeingRepository feingRepository;

    private final ResultadoRepository resultadoRepository;

    @Value("${token.api-megasena}")
    private String tokenApi;
    @Value("${url.api-loteria}")
    private String urlApi;


    @PostConstruct
    public void teste(){
        log.info("TOKEN: ", tokenApi);
    }



    public void salvarResultado(){
        ResultadoDto resultado = new ResultadoDto();
        String loteria = "megasena";
        resultado = feingRepository.buscarResultado(loteria, tokenApi);
        log.info("resultado: ", resultado.getDezenas());
        System.out.println(resultado);

        resultadoRepository.save(resultado.pegarModel());

    }
//
//    public List<ResultadoDto> listarTodos(){
//        List<Resultado> resultadoList = resultadoRepository.findAll();
//        return resultadoList.stream().map(ResultadoDto::new).collect(Collectors.toList());
//    }
}
