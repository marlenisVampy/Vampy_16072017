/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author PC
 */
public class Usuario extends Persona{
    private String nombreUsuario;
		private String usuarioPass;
 
 	//public Usuario(){}

	public Usuario()
	{
		this.nombreUsuario = "NONE";
		this.usuarioPass = "NONE";
	}//iniciarSesion Uusuario
        public Usuario(String nombreUsuario,String usuarioPass)
	{
		this.nombreUsuario = nombreUsuario;
		this.usuarioPass = nombreUsuario;
	}
	//para crear un nuevo Usuario
	public Usuario(int id,String pNo, String pAp,String rol)
	{
		super(id,pNo,pAp,rol);

	}
	
	public Usuario(int id,long cedula,String pNo, String pAp,String tel,String rol,String nombreUsuario, String usuarioPass)
	
	{	
		super(id,cedula,pNo, pAp, tel, rol);
		this.nombreUsuario = nombreUsuario;
		this.usuarioPass= usuarioPass;
		
	}
	//Crear un nuevo usuario en el Sistema, para iniciar sesion
	public Usuario(String pNo, String pAp, String nombreUsuario,String usuarioPass,String rol)
	{
		super(pNo, pAp, rol);
		this.nombreUsuario = nombreUsuario;
		this.usuarioPass= usuarioPass;

	}

	public void setNombreUsuario(String nombreUsuario) 
	{
		this.nombreUsuario= nombreUsuario;
	}

	public void setPassword(String PassW)
	{
		this.usuarioPass= usuarioPass;
	}

	public String getNombreUsuario(){return nombreUsuario;}
	public String getPassWordUsuario(){return usuarioPass;}

    
}
