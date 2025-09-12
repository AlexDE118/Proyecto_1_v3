package hospital.presentacion.login;

import hospital.logic.Service;
import hospital.logic.Usuario;
import hospital.presentacion.Sesion;

public class Controller {

    public void login(Usuario usuario) throws Exception {
        Usuario logged = Service.instance().readUsuario(usuario);
        if(!logged.getClave().equals(usuario.getClave())){
            throw new Exception("Clave o Usuario Incorrecto");
        }
        Sesion.setUsuario(logged);
    }

}
