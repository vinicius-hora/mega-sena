package com.estudo.megasema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "JOGOS")
@AllArgsConstructor
@NoArgsConstructor
public class Jogos implements Serializable {
    private static final long serialVersionUID = -499581101907843910L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "numeros")
    private String numeros;
    @Column(name = "codigo_de_sorteio")
    private Long codigoDeSorteio;
    @Column(name = "data_do_jogo")
    private LocalDateTime dataDoJogo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogos jogos)) return false;
        return id.equals(jogos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
