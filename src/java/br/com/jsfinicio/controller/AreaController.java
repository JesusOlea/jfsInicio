package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.repository.AreaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AreaController {
    private AreaModel area;
    private AreaRepository areaRepository;
    private List<AreaModel> listaDeAreas;
    
    public AreaController(){
        this.area = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.listaDeAreas = new ArrayList<>();
    }
    
    public String salvar(){
        this.areaRepository.salvar(area);
        return "listaDeAreas.xhtml?faces-rediret=true";
    }
    
    public void buscar(){
        this.listaDeAreas = this.areaRepository.buscarTodos();
    }
    
    public void buscarId(){
        this.area = this.areaRepository.buscarId(this.area.getIdArea());
    }

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<AreaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }
}
