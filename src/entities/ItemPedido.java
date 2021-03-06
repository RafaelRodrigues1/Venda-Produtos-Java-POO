package entities;

/**
 * @author RafaelRodrigues1
 */
public class ItemPedido {
    
    private Integer quantidade;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double subTotal(){
        return getProduto().getPreco() * getQuantidade();
    }
    
    public String toString(){
        return getProduto().getNome() + ", R$" +
                String.format("%.2f", getProduto().getPreco()) + ", Quantidade: " +
                getQuantidade() + ", Subtotal: R$" +
                String.format("%.2f", subTotal());
    }
}
