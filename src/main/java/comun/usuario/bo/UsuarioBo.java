package comun.usuario.bo;

import comun.usuario.modelo.Usuario;

public interface UsuarioBo {
	
	void guarda(Usuario usuario);
	
	void actualiza(Usuario usuario);
	
	void elimina(Usuario usuario);

}
