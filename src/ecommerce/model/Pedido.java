package ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;

    public Pedido(int numeroPedido, Cliente cliente, List<Produto> produtos) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = calcularValorTotal();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    private double calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
}