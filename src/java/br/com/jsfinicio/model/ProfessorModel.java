package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class ProfessorModel extends PessoaModel implements Serializable{
    
    @Column(nullable = false)
    private Long siape;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="idArea")

    private AreaModel area;

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }
    
    public Long getSiape() {
        return siape;
    }

    public void setSiape(Long siape) {
        this.siape = siape;
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entrou");
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final ProfessorModel other = (ProfessorModel) obj;
        return !(!Objects.equals(this.getIdpessoa(), other.getIdpessoa()) && (this.getIdpessoa() == null || !this.getIdpessoa().equals(other.getIdpessoa())));
    }

    @Override
        public int hashCode() {
            int hash = 5;
            hash = 41 * hash + (getIdpessoa() != null ? getIdpessoa().hashCode() : 0);
            return hash;
    }
}
