package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "area")
public class AreaModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
    
    @Column(length = 40, nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy="area", fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<ProfessorModel> listaDeProfessores;

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entrou");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AreaModel)) {
            return false;
        }
        AreaModel other = (AreaModel) obj;
        if (idArea == null) {
            if (other.idArea != null) {
                return false;
            }
        } else if (!idArea.equals(other.getIdArea())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

}
