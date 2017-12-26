package comun.controlador;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import comun.usuario.modelo.Usuario;
import comun.usuario.bo.UsuarioBo;

@Controller
public class ControladorUsuario {

	@Autowired
	private UsuarioBo usuarioBo;

	@GetMapping("/")
	public String userForm(Locale locale, Model model) {
//		model.addAttribute("jsp_usuarios", usuarioBo.list());
		return "editUsers";
	}
	
	@ModelAttribute("user")
    public Usuario formBackingObject() {
        return new Usuario();
    }

	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("jsp_usuario") @Valid Usuario usuario, BindingResult resultado, Model modelo) {

		if (resultado.hasErrors()) {
//			modelo.addAttribute("users", usuarioBo.list());
			return "editUsers";
		}

		usuarioBo.guarda(usuario);
		return "redirect:/";
	}
}
