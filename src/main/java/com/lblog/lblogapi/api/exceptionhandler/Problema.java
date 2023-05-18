package com.lblog.lblogapi.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    List<Campo> campos;

    @AllArgsConstructor
    @Getter
    public static class Campo {

        private String nome;
        private String mensagem;

    }

}