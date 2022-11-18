package ClienteAPI.ClienteAPI;

import javax.persistence.*;
import java.util.List;

@Entity

public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Profissao;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Enderecos> enderecos;


    public Cliente(String nome, String profissao, List<Enderecos> enderecos) {
        this.nome = nome;
        this.Profissao = profissao;
        this.enderecos = enderecos;

    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public String getProfissao() {
        return Profissao;
    }

    public void setProfissao(String profissao) {
        Profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Enderecos> enderecos) {
        this.enderecos = enderecos;
    }
}
