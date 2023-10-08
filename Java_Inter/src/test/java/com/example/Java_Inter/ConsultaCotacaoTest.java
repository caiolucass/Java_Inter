package com.example.Java_Inter;

import com.example.Java_Inter.enumeration.Moeda;
import com.example.Java_Inter.service.CotacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class ConsultaCotacaoTest {

	@Test
	public void testDeveRetornarACotacaoDeVendaPorData() throws Exception {
		final LocalDate data = LocalDate.of(2023, 10, 6);
		Assertions.assertEquals(new BigDecimal("5.15570"), new CotacaoService().getCotacao(Moeda.USD, data).getValorVenda());
	}

	@Test
	public void testDeveRetornarACotacaoDeCompraPorData() throws Exception {
		final LocalDate data = LocalDate.of(2023, 10, 6);
		Assertions.assertEquals(new BigDecimal("5.15570"), new CotacaoService().getCotacao(Moeda.USD, data).getValorCompra());
	}

	@Test
	public void testDeveRetornarNuloQuandoForFeriado() throws Exception {
		final LocalDate data = LocalDate.of(2023,10, 12);
		Assertions.assertNull(new CotacaoService().getCotacao(Moeda.USD, data));
	}

	@Test
	public void testDeveRetornarNuloQuandoForFinalDeSemana() throws Exception {
		final LocalDate data = LocalDate.of(2023, 10, 8);
		Assertions.assertNull(new CotacaoService().getCotacao(Moeda.USD, data));
	}

	@Test
	public void testDeveRetornarNuloQuandoDataForPosteriorAHoje() throws Exception {
		final LocalDate data = LocalDate.now().plusDays(1);
		Assertions.assertNull(new CotacaoService().getCotacao(Moeda.USD, data));
	}

	@Test
	public void testGaranteQueTodasAsMoedasEstaoOperacionais() throws Exception {
		final LocalDate data = LocalDate.of(2023, 10, 9);
		final CotacaoService consultaCotacao = new CotacaoService();
		for (Moeda moeda : Moeda.values()) {
			Assertions.assertNotNull(consultaCotacao.getCotacao(moeda, data));
		}
	}

}
