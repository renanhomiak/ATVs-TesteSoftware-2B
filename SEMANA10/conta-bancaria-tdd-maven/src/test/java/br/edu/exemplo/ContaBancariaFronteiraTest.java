package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaFronteiraTest {

    @Test
    void contaNovaDeveTerSaldoZero() {
        assertEquals(0, new ContaBancaria().getSaldo(), 0.001);
    }

    @Test
    void devePermitirSacarExatamenteOSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);

        conta.sacar(100);

        assertEquals(0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSacarDeContaVazia() {
        ContaBancaria conta = new ContaBancaria();

        conta.sacar(1);

        assertEquals(0, conta.getSaldo(), 0.001);
    }
}