package com.estudo.megasema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity(name = "resultado")
@Getter
@Setter
public class Resultado  implements Serializable {
    private static final long serialVersionUID = 1694435817494160629L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "numero_concurso")
    private int numeroConcurso;
    @Column(name = "data_concurso")
    private String dataConcurso;
    @Column(name = "acumulou")
    private Boolean acumulou;
    @Column(name = "valor_acumulado")
    private BigDecimal valorAcumulado;
    @Column(name = "dezenas")
    private List<String> dezenas;
    @Column(name = "arrecadacaoTotal")
    private BigDecimal arrecadacaoTotal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resultado resultado)) return false;
        return id.equals(resultado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
