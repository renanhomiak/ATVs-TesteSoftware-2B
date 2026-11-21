package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoTest {

    @Test
    void deveExporNomeEPreco() {
        Produto produto = new Produto("Teclado", 100.00);

        assertEquals("Teclado", produto.getNome());
        assertEquals(100.00, produto.getPreco(), 0.001);
    }
}