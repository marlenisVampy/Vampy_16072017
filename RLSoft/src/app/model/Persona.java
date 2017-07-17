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
public class Persona {
   protected static int id;                  //autoincrement 
   protected long cedula;            // se usará cuando haga el subsistema de nomina
   protected String primerNombre;
   protected String primerApellido;
   protected String telefono;
   protected String rol;
   
  /* public Persona(){
      this.cedula = 0;
      this.primerNombre = "NONE";
      this.primerApellido = "NONE";
      this.telefono = "NONE";
      this.rol = "NONE"; 
   }*/
   //constructor para usuarios
   public Persona(){}

   public Persona(int id,long cedula,String pNo, String pAp,String tel,String rol)
   {
      this.id = id;
      this.cedula = cedula;
      this.primerNombre = pNo;
      this.primerApellido = pAp;
      this.telefono = tel;
      this.rol = rol;
   }
   //constructor para Empleados --> Subsistema de Nomina
   /*public Persona(int id,long cedula,String pNo, String pAp, String tel){
      this.id = id;
      this.cedula = cedula;
      this.primerNombre = pNo;
      this.primerApellido = pAp;
      this.telefono = tel;
   }*/
   
   //constructor para usuario
   public Persona(int id, String pNo, String pAp, String rol)
   {
      this.id = id;
      this.primerNombre = pNo;
      this.primerApellido = pAp;
      this.rol = rol;
   }

   //constructor para Usuario 
   public Persona(String pNo, String pAp, String rol)
   {
      this.primerNombre = pNo;
      this.primerApellido = pAp;
      this.rol = rol;
   }


   // setters
    public void setId(int id){this.id= id;}

   public void setCedula(long cedula)
   {
      this.cedula = cedula;
   }
   
   public void setPrimerNombre(String primerNombre){
      this.primerNombre = primerNombre;
   }
   public void setPrimerApellido(String primerApellido){
      this.primerApellido = primerApellido;
   }
   public void setTelefono(String telefono){
      this.telefono = telefono;
   }

   public void setRol(String rol){this.rol = rol;}

   //getters

   public int getId(){return id;}
   public long getCedula(){ return cedula;} //Cedula empledos --> Subsistema de Nomina

   public String getPrimerNombre(){ return primerNombre;}
   public String getPrimerApellido(){ return primerApellido;}
   public String getTelefono(){ return telefono;}
   public String getRol(){return rol;}
}
    
