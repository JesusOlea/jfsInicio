package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ProfessorController {

    private ProfessorModel professor;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;
    private List<AreaModel> areas;

    public ProfessorController() {
        this.professor = new ProfessorModel();
        this.listaDeProfessores = new ArrayList<>();
        this.professorRepository = new ProfessorRepository();
    }

    public String salvar() {
        this.professorRepository.salvar(this.professor);
        return "listaDeProfessores.xhtml?faces-rediret=true";
    }

    public void buscar() {
        this.listaDeProfessores = this.professorRepository.buscarTodos();
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<AreaModel> getAreas() {
        areas = new AreaRepository().buscarTodos();
        return areas;
    }

    public void setAres(List<AreaModel> areas) {
        this.areas = areas;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

}
