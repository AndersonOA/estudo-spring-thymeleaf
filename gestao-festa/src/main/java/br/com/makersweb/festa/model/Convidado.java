package br.com.makersweb.festa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author aaristides
 */
@Entity
@Table(name = "convidado")
public class Convidado implements Serializable {

    private static final long serialVersionUID = -5720616975195248073L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private Integer quantidadeAcompanhantes;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeAcompanhantes() {
        return quantidadeAcompanhantes;
    }

    public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
        this.quantidadeAcompanhantes = quantidadeAcompanhantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Convidado convidado = (Convidado) o;

        return codigo != null ? codigo.equals(convidado.codigo) : convidado.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", quantidadeAcompanhantes=" + quantidadeAcompanhantes +
                '}';
    }
}
