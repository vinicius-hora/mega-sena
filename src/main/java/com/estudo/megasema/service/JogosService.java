package com.estudo.megasema.service;

import com.estudo.megasema.dto.jogos.JogoAleatorio;
import com.estudo.megasema.dto.jogos.JogosDto;
import com.estudo.megasema.model.Jogos;
import com.estudo.megasema.repository.JogosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class JogosService {

    private static final int NUMERO_FINAL = 60;

    private final JogosRepository jogosRepository;

    public JogoAleatorio gerarNumeroAleatorio() {
        JogoAleatorio jogoAleatorio = new JogoAleatorio();
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

        jogos.setDataDoJogo(data.toLocalDateTime());
        jogos.setNumeros(jogosDto.getNumeros());
        jogos.setNome(jogosDto.getNome());
        jogos.setEmail(jogosDto.getEmail());
        jogos.setCodigoDeSorteio(jogosDto.getCodigoDeSorteio());
        jogosRepository.save(jogos);
        log.info("jogo salvo no banco");
    }

    public List<JogosDto> listarTodos() {
        var jogos = jogosRepository.findAll();
        log.info("listando todos os jogos");
        return jogos.stream().map(JogosDto::getDto).collect(Collectors.toList());
    }
}
