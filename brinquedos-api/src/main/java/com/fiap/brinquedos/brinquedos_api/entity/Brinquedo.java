package com.fiap.brinquedos.brinquedos_api.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String classificacao;

    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = false)
    private double preco;
}