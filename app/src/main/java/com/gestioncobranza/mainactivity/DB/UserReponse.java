package com.gestioncobranza.mainactivity.DB;
import com.gestioncobranza.mainactivity.Login.Model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserReponse {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public class Bodega {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("sucursal_id")
        @Expose
        private Integer sucursalId;
        @SerializedName("encargado_id")
        @Expose
        private Integer encargadoId;
        @SerializedName("telefono")
        @Expose
        private String telefono;
        @SerializedName("direccion")
        @Expose
        private String direccion;
        @SerializedName("municipio_id")
        @Expose
        private Integer municipioId;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;

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

        public Integer getEncargadoId() {
            return encargadoId;
        }

        public void setEncargadoId(Integer encargadoId) {
            this.encargadoId = encargadoId;
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

        public Integer getMunicipioId() {
            return municipioId;
        }

        public void setMunicipioId(Integer municipioId) {
            this.municipioId = municipioId;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public class Sucursal {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("encargado_id")
        @Expose
        private Integer encargadoId;
        @SerializedName("telefono")
        @Expose
        private String telefono;
        @SerializedName("direccion")
        @Expose
        private String direccion;
        @SerializedName("municipio_id")
        @Expose
        private Integer municipioId;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getEncargadoId() {
            return encargadoId;
        }

        public void setEncargadoId(Integer encargadoId) {
            this.encargadoId = encargadoId;
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

        public Integer getMunicipioId() {
            return municipioId;
        }

        public void setMunicipioId(Integer municipioId) {
            this.municipioId = municipioId;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

}
