package com.estudo.megasema.dto.resultados;

import com.estudo.megasema.model.Resultado;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class SaveResultadoDto {

    private String nome;
    private Long numeroConcurso;
    private String dataConcurso;
    private Boolean acumulou;
    private BigDecimal valorAcumulado;
    private List<String> dezenas;
    private BigDecimal arrecadacaoTotal;


}
