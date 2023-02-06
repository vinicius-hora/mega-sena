package com.estudo.megasema.service;

import com.estudo.megasema.configuration.exception.NumberException;
import com.estudo.megasema.dto.resultados.GetResuldatoDto;
import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.model.Resultado;
import com.estudo.megasema.repository.ResultadoRepository;
import com.estudo.megasema.repository.feingRepository.ResultadoFeingRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class ResultadoService {
    private final ResultadoFeingRepository feingRepository;
    private static final String CRON_GENERATE = "0 59 20 * * 3,6";
//    MINUTO = 0 * * * * *
//    QUARTA E SABADO 20:59H = "0 59 20 * * 3,6"
    private final ResultadoRepository resultadoRepository;
    private final JogosService jogosService;
    @Value("${token.api-megasena}")
    private String tokenApi;
    @Value("${url.api-loteria}")
    private String urlApi;
    @Async
    @Scheduled(cron = CRON_GENERATE)
    public void salvarResultado(){
        ResultadoDto resultado = new ResultadoDto();
        String loteria = "megasena";
        resultado = feingRepository.buscarResultado(loteria, tokenApi);
        //atualiza o numero do concurso para salvar um novo jogo
        jogosService.pegarCodigoSorteio();

        List<Resultado> resultadoListBanco = buscarTodos();
        ResultadoDto finalResultado = resultado;

        if(Objects.isNull(resultadoListBanco)){
            resultadoRepository.save(resultado.pegarModel());
            log.info("Concurso: {} salvo ", resultado.getNumeroConcurso());
        }
        else{
            resultadoListBanco.stream().forEach(resultadoBanco -> {
                if(finalResultado.getNumeroConcurso().equals(resultadoBanco.getNumeroConcurso())){
                    log.warn("Numero do concurso existente");
                    throw new NumberException("Concurso existente");
                }
            });
            resultadoRepository.save(resultado.pegarModel());
            log.info("Concurso: {} salvo ", resultado.getNumeroConcurso());
        }

    }

    private List<Resultado> buscarTodos(){
        List<Resultado> resultadoList = resultadoRepository.findAll();
        return resultadoList;
    }

    public List<GetResuldatoDto> mostrarTodos() {
        List<Resultado> resultadoList = resultadoRepository.findAll();

        return resultadoList.stream().map(GetResuldatoDto::new).collect(Collectors.toList());
    }
}
