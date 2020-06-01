package converter;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.repository.AreaRepository;
import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.FacesConverter;  
  
@FacesConverter(forClass = AreaModel.class, value = "areaConverter")  
public class StringerConverter implements Converter {  
  
    @Override  
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        if (value != null && !value.equals("")) {
            AreaModel a = new AreaRepository().buscarId(Long.valueOf(value));
            //System.out.println(a);
            return a;
        }
        return null;
    }  
  
    @Override  
    public String getAsString(FacesContext context, UIComponent component, Object value) {  
       
       if (value instanceof AreaModel) {
            AreaModel area = (AreaModel) value;
            return String.valueOf(area.getIdArea());
        }
        return "";
    }
  
}