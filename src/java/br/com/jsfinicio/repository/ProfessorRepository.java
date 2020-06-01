package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository extends Conexao{
    public void salvar(ProfessorModel professor){
        super.inicializa();
        super.getSess().save(professor);
        super.executar();
    }
    
    public List<ProfessorModel> buscarTodos(){
        List<ProfessorModel> listaDeProfessores = new ArrayList<>();
        super.inicializa();
        listaDeProfessores = super.getSess().createQuery("from ProfessorModel").list();
        super.executar();
        return listaDeProfessores;
    }
    
}
