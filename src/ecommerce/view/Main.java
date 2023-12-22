package ecommerce.view;

import ecommerce.controller.ClienteController;
import ecommerce.controller.ProdutoController;
import ecommerce.model.Cliente;
import ecommerce.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ClienteController clienteController;
    private static ProdutoController produtoController = new ProdutoController();
    private static List<Produto> listaDeProdutos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarProdutos();

        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Vendedor");
        int escolhaTipo = scanner.nextInt();
        scanner.nextLine();

        if (escolhaTipo == 1) {
        	
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Digite o endereço do cliente: ");
            String enderecoCliente = scanner.nextLine();
            System.out.print("Digite o telefone do cliente: ");
            String telefoneCliente = scanner.nextLine();

            Cliente cliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente);
            clienteController = new ClienteController(cliente);
            
            menuCliente();

        } else if (escolhaTipo == 2) {
            menuVendedor();
        } else {
            System.out.println("Escolha inválida!");
        }
    }

    private static void menuCliente() {
        boolean continuarCliente = true;
        while (continuarCliente) {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Pedidos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolhaCliente = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolhaCliente) {
                case 1:
                    clienteController.comprar(listaDeProdutos);
                    break;
                case 2:
                    clienteController.listarPedidos();
                    break;
                case 3:
                    continuarCliente = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }
    }

    private static void menuVendedor() {
        boolean continuarVendedor = true;
        while (continuarVendedor) {
            System.out.println("\n=== MENU VENDEDOR ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Deletar Produto");
            System.out.println("4. Buscar Produto");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int escolhaVendedor = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolhaVendedor) {
                case 1:
                    cadastrarNovoProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    deletarProduto();
                    break;
                case 4:
                    buscarProduto();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    continuarVendedor = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }
    }

    private static void cadastrarNovoProduto() {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();

        Produto novoProduto = new Produto(id, nome, preco, quantidade);
        produtoController.cadastrarProduto(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void atualizarProduto() {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        int id = scanner.nextInt();
        Produto produtoExistente = produtoController.buscarProduto(id);

        if (produtoExistente != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.next();

            System.out.print("Digite o novo preço do produto: ");
            double novoPreco = scanner.nextDouble();

            System.out.print("Digite a nova quantidade do produto: ");
            int novaQuantidade = scanner.nextInt();

            Produto produtoAtualizado = new Produto(id, novoNome, novoPreco, novaQuantidade);
            produtoController.atualizarProduto(produtoAtualizado);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void deletarProduto() {
        System.out.print("Digite o ID do produto a ser deletado: ");
        int id = scanner.nextInt();
        Produto produtoParaDeletar = produtoController.buscarProduto(id);

        if (produtoParaDeletar != null) {
            produtoController.deletarProduto(produtoParaDeletar);
            System.out.println("Produto deletado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void buscarProduto() {
        System.out.print("Digite o ID do produto a ser buscado: ");
        int id = scanner.nextInt();
        Produto produtoEncontrado = produtoController.buscarProduto(id);

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void listarProdutos() {
        List<Produto> produtos = produtoController.listarProdutos();
        if (!produtos.isEmpty()) {
            System.out.println("\n=== LISTA DE PRODUTOS ===");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        } else {
            System.out.println("Nenhum produto cadastrado ainda.");
        }
    }

    private static void inicializarProdutos() {
        listaDeProdutos.add(new Produto(1, "Produto A", 50.0, 10));
        listaDeProdutos.add(new Produto(2, "Produto B", 30.0, 15));
        listaDeProdutos.add(new Produto(3, "Produto C", 20.0, 20));
    }
}