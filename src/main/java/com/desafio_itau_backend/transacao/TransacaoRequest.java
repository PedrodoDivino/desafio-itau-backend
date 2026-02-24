package com.desafio_itau_backend.transacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransacaoRequest {
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}