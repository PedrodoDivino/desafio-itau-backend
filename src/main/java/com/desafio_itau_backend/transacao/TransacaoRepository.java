package com.desafio_itau_backend.transacao;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.DoubleStream;

@Repository
public class TransacaoRepository {

    private List<TransacaoRequest> transacoes = new ArrayList<>();

    public void add(TransacaoRequest transacaoRequest) {
        transacoes.add(transacaoRequest);
    }

    public void limpar() {
        transacoes.clear();
    }

    public DoubleSummaryStatistics estatitica(OffsetDateTime horaInicial) {
        if (transacoes.isEmpty()){
            return new DoubleSummaryStatistics();
        }else {
            final BigDecimal[] valoresFiltrados = transacoes.stream().filter(t -> t.getDataHora().isAfter(horaInicial) ||
                    t.getDataHora().equals(horaInicial)).map(TransacaoRequest::getValor).toArray(BigDecimal[]::new);
            DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);
            return  doubleStream.summaryStatistics();
        }
    }
}
