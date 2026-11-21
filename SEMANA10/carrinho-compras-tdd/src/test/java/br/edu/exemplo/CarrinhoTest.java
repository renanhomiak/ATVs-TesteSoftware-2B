package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {

    private static final double DELTA = 0.001;

    @Test
    void carrinhoNovoDeveTerTotalZero() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveSomarUmProdutoAdicionado() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Teclado", 100.00));

        assertEquals(100.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveSomarVariosProdutos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Teclado", 100.00));
        carrinho.adicionar(new Produto("Mouse", 50.00));

        assertEquals(150.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveSubtrairProdutoRemovido() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 100.00);
        Produto mouse = new Produto("Mouse", 50.00);
        carrinho.adicionar(teclado);
        carrinho.adicionar(mouse);

        carrinho.remover(mouse);

        assertEquals(100.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveRejeitarProdutoComPrecoNegativo() {
        Carrinho carrinho = new Carrinho();
        Produto invalido = new Produto("Teclado", -100.00);

        assertThrows(IllegalArgumentException.class,
                () -> carrinho.adicionar(invalido));
        assertEquals(0, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveAplicarDescontoQuandoSubtotalMaiorQue500() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Monitor", 600.00));

        assertEquals(540.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void naoDeveAplicarDescontoEm499e99() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Item", 499.99));

        assertEquals(499.99, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveAplicarDescontoEm500Exatos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Item", 500.00));

        assertEquals(450.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveAplicarDescontoEm500e01() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Item", 500.01));

        assertEquals(450.009, carrinho.getTotal(), DELTA);
    }
}