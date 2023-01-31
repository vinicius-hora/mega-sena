package com.estudo.megasema.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "resultado")
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
}
