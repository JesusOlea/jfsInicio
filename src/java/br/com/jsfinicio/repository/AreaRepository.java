package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

public class AreaRepository extends Conexao{
    public void salvar(AreaModel area){
        super.inicializa();
        super.getSess().save(area);
        super.executar();
    }
    
    public List<AreaModel> buscarTodos(){
        List<AreaModel> listaDeAreas = new ArrayList<>();
        super.inicializa();
        listaDeAreas = super.getSess().createQuery("from AreaModel").list();
        super.executar();
        return listaDeAreas;
    }
    
    public AreaModel buscarId(Long id){
        AreaModel area = null;
        super.inicializa();
        area = (AreaModel) super.getSess().get(AreaModel.class, id);
        super.executar();
        return area;
    }

}
