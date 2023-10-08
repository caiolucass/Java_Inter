package com.example.Java_Inter.service;

import com.example.Java_Inter.enumeration.Moeda;
import com.example.Java_Inter.model.Cotacao;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CotacaoService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public Cotacao getCotacao(final Moeda moeda, final LocalDate localDate) throws IOException {
        final URL url = new URL(String.format("https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoMoedaDia(moeda='%s',dataCotacao='%s')?$top=1&$orderby=dataHoraCotacao%%20desc&$format=json&$select=cotacaoCompra,cotacaoVenda",
                moeda, FORMATTER.format(localDate)));
        final URLConnection request = url.openConnection();
        request.connect();

        try (final InputStreamReader isr = new InputStreamReader((InputStream) request.getContent())) {
            final JsonObject jsonObject = new JsonParser().parse(isr).getAsJsonObject();
            for (final JsonElement cotacaoElement : jsonObject.getAsJsonArray("value")) {
                final JsonObject cotacaoObject = cotacaoElement.getAsJsonObject();
                return new Cotacao(localDate, moeda, cotacaoObject.get("cotacaoCompra").getAsBigDecimal(),
                        cotacaoObject.get("cotacaoVenda").getAsBigDecimal());
            }
        }
        return null;
    }
}
