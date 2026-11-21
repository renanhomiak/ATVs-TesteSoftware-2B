package br.edu.exemplo;

public class BubbleSort {

    private int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        for (int i = 0; i < numeros.length - 1; i++) {
            boolean trocou = false;

            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }

    private void trocar(int a, int b) {
        int temp = numeros[a];
        numeros[a] = numeros[b];
        numeros[b] = temp;
    }

    public int[] getNumeros() {
        return numeros;
    }
}