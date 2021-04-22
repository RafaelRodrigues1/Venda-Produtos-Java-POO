package Aplication;

/**
 * @author RafaelRodrigues1
 */
import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.StatusPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        Scanner in = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Insira os dados do cliente:");
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("E-mail: ");
        String email = in.nextLine();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Cliente c1 = new Cliente(nome, email, df.parse(in.nextLine()));
        
        System.out.println("Insira os dados do pedido:");
        System.out.print("Status: ");
        Pedido p1 = new Pedido(c1, StatusPedido.valueOf(in.nextLine()));
        
        System.out.print("Quantos itens esse pedido possui? ");
        int c = in.nextInt();
        in.nextLine();
        for(int i=0; i<c; i++){
            System.out.println("Insira os dados do item #" + (i+1) + ":");
            System.out.print("Nome do produto: ");
            String nomeProduto = in.nextLine();
            System.out.print("Preço do produto: R$");
            Double precoProduto = in.nextDouble();            
            System.out.print("Quantidade: ");
            Integer quantProduto = in.nextInt();
            in.nextLine();
            p1.getListaItem().add(new ItemPedido(quantProduto, new Produto(nomeProduto, precoProduto)));
        }
        System.out.println(p1.resumoPedido());    
    }
}
