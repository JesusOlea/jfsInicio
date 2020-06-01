/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Frank
 */
@Entity
@Table(name = "disciplina")
public class DisciplinaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDisciplina;

    private String nome;
    private String cargaHorariaTotal;

    @ManyToMany
    @JoinTable(name = "disciplinas_alunos",
            joinColumns = @JoinColumn(name = "idDisciplina"),
            inverseJoinColumns = @JoinColumn(name = "idPessoaAluno"))
    private List<AlunoModel> listaDeAlunos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPessoaProfessor", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private ProfessorModel professor;

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(String cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    
}
