package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static final double LIMITE_DESCONTO = 500.00;
    private static final double PERCENTUAL_DESCONTO = 0.10;

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public double getTotal() {
        double subtotal = calcularSubtotal();
        if (subtotal >= LIMITE_DESCONTO) {
            return subtotal * (1 - PERCENTUAL_DESCONTO);
        }
        return subtotal;
    }

    private double calcularSubtotal() {
        double soma = 0;
        for (Produto p : produtos) {
            soma += p.getPreco();
        }
        return soma;
    }
}