package hospital.presentacion.login;

import hospital.logic.Service;
import hospital.logic.Usuario;
import hospital.presentacion.Sesion;


public class Controller {

    hospital.presentacion.login.View view;
    hospital.presentacion.login.Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        model.addPropertyChangeListener(view);
    }

    // En LoginController
    public Usuario login(Usuario usuario) throws Exception {
        // Buscar usuario en la lista
        Usuario u = Service.instance().readUsuario(usuario);

        // Validar clave
        if (!u.getClave().equals(usuario.getClave())) {
            throw new Exception("Clave incorrecta");
        }

        return u; // devuelvo el usuario completo
    }



}
