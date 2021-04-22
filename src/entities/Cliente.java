package entities;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author RafaelRodrigues1
 */
public class Cliente {
    
    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    private String nome;
    private String email;
    private Date dataNascimento;

    public Cliente() {
    }

    public Cliente(String nome, String email, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString(){
        return "Cliente: " + getNome() +
                " (" + df.format(getDataNascimento()) + ") - " +
                getEmail();                
    }
}
