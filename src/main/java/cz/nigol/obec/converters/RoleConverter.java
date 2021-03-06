package cz.nigol.obec.converters;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cz.nigol.obec.entities.Role;
import cz.nigol.obec.services.UserService;

@Named
@ApplicationScoped
public class RoleConverter implements Converter {
    @Inject
    private UserService userService;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Role result = null;
        if (arg2 != null && !"".equals(arg2)) {
            result = userService.getRoleById(Long.parseLong(arg2));
        }
        return result;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        String result = "";
        if (arg2 != null) {
            Role role = (Role) arg2;
            result = result + role.getId();
        }
        return result;
    }
}
