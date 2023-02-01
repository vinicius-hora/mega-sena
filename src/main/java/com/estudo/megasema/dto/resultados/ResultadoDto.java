package com.estudo.megasema.dto.resultados;

import com.estudo.megasema.model.Resultado;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResultadoDto implements Serializable {
    private String nome;
    private int numeroConcurso;
    private String dataConcurso;
    private Boolean acumulou;
    private BigDecimal valorAcumulado;
    private List<String> dezenas;
    private BigDecimal arrecadacaoTotal;

    public Resultado pegarModel(){
        Resultado resultado = new Resultado();
        resultado.setNome(this.nome);
        resultado.setAcumulou(this.acumulou);
        resultado.setDezenas(this.dezenas);
        resultado.setDataConcurso(this.dataConcurso);
        resultado.setNumeroConcurso(this.numeroConcurso);
        resultado.setValorAcumulado(this.valorAcumulado);
        resultado.setArrecadacaoTotal(this.arrecadacaoTotal);
        return resultado;
    }
}
