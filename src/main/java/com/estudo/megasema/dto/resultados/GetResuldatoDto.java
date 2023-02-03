package com.estudo.megasema.dto.resultados;

import com.estudo.megasema.model.Resultado;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GetResuldatoDto {
    private Long id;
    private String nome;
    private int numeroConcurso;
    private String dataConcurso;
    private Boolean acumulou;
    private BigDecimal valorAcumulado;
    private List<String> dezenas;
    private BigDecimal arrecadacaoTotal;

    public GetResuldatoDto(Resultado resultado){
        this.id = resultado.getId();
        this.nome = resultado.getNome();
        this.numeroConcurso = resultado.getNumeroConcurso();
        this.dataConcurso = resultado.getDataConcurso();
        this.acumulou = resultado.getAcumulou();
        this.dezenas = resultado.getDezenas();
        this.valorAcumulado = resultado.getValorAcumulado();
        this.arrecadacaoTotal = resultado.getArrecadacaoTotal();
    }
}
