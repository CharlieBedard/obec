package cz.nigol.obec.dev;

import java.util.HashSet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import cz.nigol.obec.beans.ApplicationBean;
import cz.nigol.obec.entities.Role;
import cz.nigol.obec.entities.User;
import cz.nigol.obec.services.UserService;

@Named
@RequestScoped
public class PrepareDevData {
    @Inject
    private UserService userService;
    @Inject
    private ApplicationBean applicationBean;

    public void createData() {
        User user = new User();
        user.setUserId("aaa");
        user.setFullName("Josef Test");
        user.setPassword(BCrypt.hashpw("aaa", BCrypt.gensalt()));
        user.setActive(true);
        Role role = new Role();
        role.setName("aaa");
        role.setPaths(new HashSet<>(applicationBean.getSecuredPaths()));
        user.setRole(userService.saveRole(role));
        userService.saveUser(user);
    }
}
