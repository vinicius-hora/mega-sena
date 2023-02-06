package com.estudo.megasema.service;

import com.estudo.megasema.dto.jogos.GetJogosDto;
import com.estudo.megasema.dto.jogos.JogoAleatorioDto;
import com.estudo.megasema.dto.jogos.JogosDto;
import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.model.Jogos;
import com.estudo.megasema.model.Resultado;
import com.estudo.megasema.repository.JogosRepository;
import com.estudo.megasema.repository.feingRepository.ResultadoFeingRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class JogosService {
    private static final int NUMERO_FINAL = 60;

    private static Long CODIGO_SORTEIO;
    private final JogosRepository jogosRepository;
    private String loteria = "megasena";
    @Value("${token.api-megasena}")
    private String tokenApi;

    private static final int OITO_HORAS_PM = 20;
    private static final int NOVE_HORAS_PM = 21;
    private final ResultadoFeingRepository feingRepository;

    @PostConstruct
    public void pegarCodigoSorteio(){
        ResultadoDto resultado = feingRepository.buscarResultado(loteria,tokenApi);
        CODIGO_SORTEIO = resultado.getNumeroConcurso() + 1;
    }

    public JogoAleatorioDto gerarNumeroAleatorio() {
        JogoAleatorioDto jogoAleatorio = new JogoAleatorioDto();
        String[] numeros = new String[6];
        Random gerador = new Random();
        int numeroAleatorio;

        for(int contador = 0; contador < numeros.length; contador ++){
            numeroAleatorio = gerador.nextInt(NUMERO_FINAL);
            if(numeros[0] == null){
                numeros[contador] = String.valueOf(numeroAleatorio);
                contador ++;
            }
            numeros[contador] = String.valueOf(numeroAleatorio);

            while (Boolean.TRUE.equals(verificarIgualdade(numeros, numeroAleatorio))){

                numeroAleatorio = gerador.nextInt(NUMERO_FINAL);
            }

            numeros[contador] = String.valueOf(numeroAleatorio);

        }

        jogoAleatorio.setNumeros(Arrays.toString(numeros));
        log.info("numeros aleatórios gerados");
        return jogoAleatorio;
    }
    private Boolean verificarIgualdade(String[] numeros, int contadorAtual){

        if(Arrays.stream(numeros).toList().contains(String.valueOf(contadorAtual))){
            return true;
        }
        return false;
    }

    public void salvar(JogosDto jogosDto) {
        var data = LocalDateTime.now().atZone(ZoneOffset.UTC);
        Jogos jogos = new Jogos();
        if(Boolean.TRUE.equals(verificarHora(data))){
            throw new RuntimeException(" Horario para jogos até 19:59 ou após 20:59");
        }

        if(Boolean.FALSE.equals(verificarNumeros(jogosDto.getNumeros()))){
            throw new RuntimeException(" Dezenas informadas diferente de 6 ou maior que 60");
        }

        jogos.setDataDoJogo(data.toLocalDateTime());
        jogos.setNumeros(jogosDto.getNumeros());
        jogos.setNome(jogosDto.getNome());
        jogos.setEmail(jogosDto.getEmail());
        jogos.setCodigoDeSorteio(CODIGO_SORTEIO);
        jogos.setCidade(jogosDto.getCidade());
        jogosRepository.save(jogos);
        log.info("jogo salvo no banco");
    }

    private Boolean verificarHora(ZonedDateTime data) {

        Long horaAtual = (long) data.getHour();

        if (data.getHour() >= OITO_HORAS_PM && horaAtual < NOVE_HORAS_PM){
            return true;
        }
        return false;
    }

    private boolean verificarNumeros(List<String> numeros) {
        if(numeros.size() == 6){
            for(String n:numeros){
                if(Long.valueOf(n) > NUMERO_FINAL){
                    return false;
                }
            }
           return true;
        }
        return false;
    }

    public List<GetJogosDto> listarTodos() {
        var jogos = jogosRepository.findAll();
        log.info("listando todos os jogos");
        return jogos.stream().map(GetJogosDto::getDto).collect(Collectors.toList());
    }
}
