package entities;

/**
 * @author RafaelRodrigues1
 */
public enum StatusPedido {
    
    PAGAMENTO_PENDENTE("Pagamento pendente"),
    PROCESSANDO("Processando"),
    PAGO("Pago"),
    ENVIADO("Enviado");
    
    private String status;

    private StatusPedido(String status) {
        this.status = status;
    }        
}
