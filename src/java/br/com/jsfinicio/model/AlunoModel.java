/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Frank
 */
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel implements Serializable {

    @Column(nullable = false)
    private int ra;

    @ManyToMany(mappedBy = "listaDeAlunos")
    private List<DisciplinaModel> listaDeDisciplinas;

    public AlunoModel() {
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }

}
