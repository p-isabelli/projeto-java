package ecommerce.controller;

import ecommerce.model.Cliente;
import ecommerce.model.Pedido;
import ecommerce.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private Cliente cliente;
    private List<Pedido> listaDePedidos;

    public ClienteController(Cliente cliente) {
        this.cliente = cliente;
        this.listaDePedidos = new ArrayList<>();
    }

    public void comprar(List<Produto> listaDeProdutos) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> carrinho = new ArrayList<>();

        boolean continuarComprando = true;
        while (continuarComprando) {
            System.out.println("Produtos disponíveis:");
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeProdutos.get(i));
            }

            System.out.print("Digite o número do produto que deseja comprar (0 para sair): ");
            int escolha = scanner.nextInt();
            if (escolha == 0) {
                continuarComprando = false;
            } else if (escolha > 0 && escolha <= listaDeProdutos.size()) {
                Produto produtoSelecionado = listaDeProdutos.get(escolha - 1);
                carrinho.add(produtoSelecionado);
                System.out.println("Produto adicionado ao carrinho: " + produtoSelecionado.getNome());
            } else {
                System.out.println("Escolha inválida!");
            }
        }

        if (!carrinho.isEmpty()) {
            Pedido novoPedido = new Pedido(listaDePedidos.size() + 1, cliente, carrinho);
            listaDePedidos.add(novoPedido);
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Nenhum produto foi selecionado.");
        }
    }

    public void listarPedidos() {
        if (!listaDePedidos.isEmpty()) {
            System.out.println("Pedidos de " + cliente.getNome() + ":");
            for (Pedido pedido : listaDePedidos) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Nenhum pedido realizado por " + cliente.getNome() + " ainda.");
        }
    }
}