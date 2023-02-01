package com.estudo.megasema.repository.feingRepository;

import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.model.Resultado;
import lombok.SneakyThrows;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements ResultadoFeingRepository{


    @SneakyThrows
    @Override
    public ResultadoDto buscarResultado(String loteria, String token) {
        throw new Exception("Erro ao buscar resultado da loteria");
    }
}
