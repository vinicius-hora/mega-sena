package com.estudo.megasema.dto.jogos;

import com.estudo.megasema.model.Jogos;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class GetJogosDto {
    private Long id;
    private String nome;
    private List<String> numeros;
    private Long codigoDeSorteio;
    private LocalDateTime dataDoJogo;
    private String cidade;

    public static GetJogosDto getDto(Jogos jogos) {
        GetJogosDto dto = new GetJogosDto();
        dto.setId(jogos.getId());
        dto.setNome(jogos.getNome());
        dto.setNumeros(jogos.getNumeros());
        dto.setDataDoJogo(jogos.getDataDoJogo());
        dto.setCodigoDeSorteio(jogos.getCodigoDeSorteio());
        dto.setCidade(jogos.getCidade());

        return dto;
    }
}
