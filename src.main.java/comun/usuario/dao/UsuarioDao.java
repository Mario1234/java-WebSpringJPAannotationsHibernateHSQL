package comun.usuario.dao;

import comun.usuario.modelo.Usuario;

public interface UsuarioDao {
	
	void guarda(Usuario usuario);
	
	void actualiza(Usuario usuario);
	
	void elimina(Usuario usuario);

}
