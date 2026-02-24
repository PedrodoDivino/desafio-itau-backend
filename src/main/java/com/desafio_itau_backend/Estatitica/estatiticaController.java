package com.desafio_itau_backend.Estatitica;

import com.desafio_itau_backend.transacao.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping(value = "/estatica", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j

public class estatiticaController {
    private final Integer intervaloEmSegundos = 60;
    private TransacaoRepository transacaoRepository;

    public estatiticaController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity estatitica(){
        log.info("Calcular as estatisticas");

        final var horaInicial = OffsetDateTime.now().minusSeconds(intervaloEmSegundos);
        return  ResponseEntity.ok(transacaoRepository.estatitica(horaInicial));
    }

}
