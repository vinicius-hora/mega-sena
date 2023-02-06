package com.estudo.megasema.dto.jogos;

import com.estudo.megasema.model.Jogos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class JogosDto {
    private Long id;
    private String nome;
    private String email;
    private List<String> numeros;
//    private Long codigoDeSorteio;
    private LocalDateTime dataDoJogo;

    private String cidade;

    public static JogosDto getDto(Jogos jogos) {
        JogosDto dto = new JogosDto();
        dto.setId(jogos.getId());
        dto.setNome(jogos.getNome());
        dto.setNumeros(jogos.getNumeros());
//        dto.setEmail(jogos.getEmail());
        dto.setDataDoJogo(jogos.getDataDoJogo());
        dto.setCidade(jogos.getCidade());

        return dto;
    }



}
