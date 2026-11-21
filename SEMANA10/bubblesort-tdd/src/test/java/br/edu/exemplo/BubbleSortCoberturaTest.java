package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortCoberturaTest {

    private int[] ordenar(int... entrada) {
        BubbleSort bs = new BubbleSort(entrada);
        bs.ordenar();
        return bs.getNumeros();
    }

    @Test
    void deveManterVetorVazio() {
        assertArrayEquals(new int[]{}, ordenar());
    }

    @Test
    void deveManterVetorComUmElemento() {
        assertArrayEquals(new int[]{7}, ordenar(7));
    }

    @Test
    void deveOrdenarDoisElementosInvertidos() {
        assertArrayEquals(new int[]{1, 2}, ordenar(2, 1));
    }

    @Test
    void deveOrdenarVetorEmOrdemDecrescente() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ordenar(5, 4, 3, 2, 1));
    }

    @Test
    void deveOrdenarNumerosNegativos() {
        assertArrayEquals(new int[]{-5, -1, 0, 3}, ordenar(3, -1, 0, -5));
    }

    @Test
    void deveManterVetorComTodosElementosIguais() {
        assertArrayEquals(new int[]{2, 2, 2}, ordenar(2, 2, 2));
    }
}