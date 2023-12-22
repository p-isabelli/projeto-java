package ecommerce.controller;

import ecommerce.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> listaDeProdutos;

    public ProdutoController() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        listaDeProdutos.add(produto);
    }

    public void deletarProduto(Produto produto) {
        listaDeProdutos.remove(produto);
    }

    public void atualizarProduto(Produto produtoAtualizado) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getId() == produtoAtualizado.getId()) {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
                produto.setQuantidade(produtoAtualizado.getQuantidade());
                break;
            }
        }
    }

    public List<Produto> listarProdutos() {
        return listaDeProdutos;
    }

    public Produto buscarProduto(int idProduto) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getId() == idProduto) {
                return produto;
            }
        }
        return null; 
    }
}