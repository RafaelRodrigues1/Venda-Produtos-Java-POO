package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RafaelRodrigues1
 */
public class Pedido {
    
    final private Date data = new Date();
    private StatusPedido statusPedido;
    private Cliente cliente;
    private List<ItemPedido> listaItem = new ArrayList<>();
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public Pedido() {
    }

    public Pedido(Cliente cliente, StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<ItemPedido> listaItem) {
        this.listaItem = listaItem;
    }
    
    public String getData(){
        return df.format(data);
    }
    
    public void addItem(ItemPedido itemPedido){
        listaItem.add(itemPedido);
    }
    
    public void removeItem(ItemPedido itemPedido){
        listaItem.remove(itemPedido);
    }
    
    public Double totalPedido(){
        Double soma = 0d;
        for(ItemPedido i: listaItem){
            soma += i.subTotal();
        }
        return soma;
    }
    
    public String resumoPedido(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo do pedido:\n");
        sb.append("Data e hora do pedido: ").append(getData());        
        sb.append("\nStatus do pedido: ").append(getStatusPedido());
        sb.append("\nCliente: ");
        sb.append(getCliente().getNome()).append(" ");
        sb.append(sdf.format(getCliente().getDataNascimento()));
        sb.append(" - ").append(getCliente().getEmail());
        sb.append("\nItens do pedido:\n");
        for(ItemPedido item: listaItem){            
            sb.append(item.getProduto().getNome()).append(", ");
            sb.append("R$").append(item.getProduto().getPreco()).append(", ");
            sb.append("Quantidade: ").append(item.getQuantidade()).append(", ");
            sb.append("Subtotal: R$").append(item.subTotal()).append("\n");
        }
        sb.append("Preço total: R$").append(totalPedido());
        return sb.toString();
    }
}
