package com.example.Java_Inter.model;

import com.example.Java_Inter.enumeration.Moeda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moeda", length = 10, nullable = false)
    private Moeda moeda;

    @Column(name = "data", length = 10, nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Column(name = "valor_compra", length = 10, nullable = false)
    private BigDecimal valorCompra;

    @Column(name = "valor_venda", length = 10, nullable = false)
    private BigDecimal valorVenda;

    public Cotacao(final LocalDate data, final Moeda moeda, final BigDecimal valorCompra, final BigDecimal valorVenda) {
        this.data = data;
        this.moeda = moeda;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cotacao cotacao = (Cotacao) o;
        return moeda == cotacao.moeda &&
                Objects.equals(data, cotacao.data) &&
                Objects.equals(valorCompra, cotacao.valorCompra) &&
                Objects.equals(valorVenda, cotacao.valorVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moeda, data, valorCompra, valorVenda);
    }

    public int compareTo(final Cotacao cotacao) {
        final int indiceCompareResult = this.moeda.compareTo(cotacao.getMoeda());
        if (indiceCompareResult == 0) {
            return this.data.compareTo(cotacao.getData());
        }
        return indiceCompareResult;
    }
}
