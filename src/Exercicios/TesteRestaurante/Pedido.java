package Exercicios.TesteRestaurante;

import java.util.*;

public class Pedido {
    private int numero;
    private String cliente;
    private List<Prato> pratos;
    private double total;

    public Pedido(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.pratos = new ArrayList<>();
        this.total = 0.0;
    }

    public String getCliente() {
        return cliente;
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
        total += prato.getPreco();
    }

    public void visualizarPedido() {
        System.out.println("Pedido Número: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Pratos:");
        for (Prato prato : pratos) {
            System.out.println("- " + prato.getNome() + " - " + prato.getPreco());
        }
        System.out.println("Total: " + total);
    }
}
