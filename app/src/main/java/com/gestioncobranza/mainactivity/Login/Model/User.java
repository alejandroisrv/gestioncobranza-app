package com.gestioncobranza.mainactivity.Login.Model;

import com.gestioncobranza.mainactivity.DB.UserReponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sucursal_id")
    @Expose
    private Integer sucursalId;
    @SerializedName("bodega_id")
    @Expose
    private Integer bodegaId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cedula")
    @Expose
    private String cedula;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("role")
    @Expose
    private Integer role;
    @SerializedName("sucursal")
    @Expose
    private UserReponse.Sucursal sucursal;
    @SerializedName("bodega")
    @Expose
    private UserReponse.Bodega bodega;

    public User(Integer id, String name, String email, Integer role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Integer getBodegaId() {
        return bodegaId;
    }

    public void setBodegaId(Integer bodegaId) {
        this.bodegaId = bodegaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


    public UserReponse.Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(UserReponse.Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public UserReponse.Bodega getBodega() {
        return bodega;
    }

    public void setBodega(UserReponse.Bodega bodega) {
        this.bodega = bodega;
    }


    public String getAtributeRole(){
        switch (this.role) {
            case 1: return "Administrador";
            case 2: return "Administrador de bodegas";
            case 3: return "Cobrador";
            case 4: return "Vendedor";
            default: return "";
        }
    }

}
