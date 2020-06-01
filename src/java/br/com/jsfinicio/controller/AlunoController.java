package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.repository.AlunoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AlunoController {
    
    private AlunoModel alunoModel;
    private AlunoRepository alunoRepository;
    private List<AlunoModel> listaDeAlunos;
    
    public AlunoController(){
        this.alunoModel = new AlunoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeAlunos =  new ArrayList<>();
    }
    
    public String salvar(){
        this.alunoRepository.salvar(this.alunoModel);
        return "buscarAluno.xhtml?faces-rediret=true";
    }

    public void buscar(){
        this.listaDeAlunos = this.alunoRepository.buscarTodos();
    }
    
    public void editar(){
        
    }
    
    public void remover(){
        
    }
    
    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
    
}
