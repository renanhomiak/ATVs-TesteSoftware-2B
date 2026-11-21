package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoCoberturaTest {

    @Test
    void deveExporNomeDoProduto() {
        assertEquals("Teclado", new Produto("Teclado").getNome());
    }

    @Test
    void naoDeveAdicionarQuantidadeZero() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(0);

        assertEquals(0, produto.getQuantidade());
    }

    @Test
    void devePermitirRetirarTodoOEstoque() {
        Produto produto = new Produto("Teclado");
        produto.adicionarEstoque(10);

        produto.retirarEstoque(10);

        assertEquals(0, produto.getQuantidade());
    }

    @Test
    void naoDeveRetirarDeProdutoSemEstoque() {
        Produto produto = new Produto("Teclado");

        produto.retirarEstoque(1);

        assertEquals(0, produto.getQuantidade());
    }
}