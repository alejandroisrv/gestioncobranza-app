package com.gestioncobranza.mainactivity.DB;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClienteDB {

    public class Cliente {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("sucursal_id")
        @Expose
        private Integer sucursalId;
        @SerializedName("cod")
        @Expose
        private String cod;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("cedula")
        @Expose
        private String cedula;
        @SerializedName("direccion")
        @Expose
        private String direccion;
        @SerializedName("adicional")
        @Expose
        private String adicional;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("telefono")
        @Expose
        private String telefono;
        @SerializedName("municipio_id")
        @Expose
        private Integer municipioId;
        @SerializedName("ruta")
        @Expose
        private Integer ruta;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("pagos_clientes_count")
        @Expose
        private Integer pagosClientesCount;
        @SerializedName("pagos_clientes")
        @Expose
        private List<PagosCliente> pagosClientes = null;
        @SerializedName("municipio")
        @Expose
        private Municipio municipio;

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

        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getAdicional() {
            return adicional;
        }

        public void setAdicional(String adicional) {
            this.adicional = adicional;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public Integer getMunicipioId() {
            return municipioId;
        }

        public void setMunicipioId(Integer municipioId) {
            this.municipioId = municipioId;
        }

        public Integer getRuta() {
            return ruta;
        }

        public void setRuta(Integer ruta) {
            this.ruta = ruta;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getPagosClientesCount() {
            return pagosClientesCount;
        }

        public void setPagosClientesCount(Integer pagosClientesCount) {
            this.pagosClientesCount = pagosClientesCount;
        }

        public List<PagosCliente> getPagosClientes() {
            return pagosClientes;
        }

        public void setPagosClientes(List<PagosCliente> pagosClientes) {
            this.pagosClientes = pagosClientes;
        }

        public Municipio getMunicipio() {
            return municipio;
        }

        public void setMunicipio(Municipio municipio) {
            this.municipio = municipio;
        }

    }

    public class Clientes {

        @SerializedName("CL")
        @Expose
        private ArrayList<Cliente> cL = null;

        public ArrayList<Cliente> getClientList() {
            return cL;
        }

        public void setClientList(ArrayList<Cliente> cL) {
            this.cL = cL;
        }

    }


    public class Municipio {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("municipio")
        @Expose
        private String municipio;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("sucursal_id")
        @Expose
        private Object sucursalId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMunicipio() {
            return municipio;
        }

        public void setMunicipio(String municipio) {
            this.municipio = municipio;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getSucursalId() {
            return sucursalId;
        }

        public void setSucursalId(Object sucursalId) {
            this.sucursalId = sucursalId;
        }

    }

    public class PagosCliente {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cliente_id")
        @Expose
        private Integer clienteId;
        @SerializedName("venta_id")
        @Expose
        private Integer ventaId;
        @SerializedName("acuerdo_pago_id")
        @Expose
        private Integer acuerdoPagoId;
        @SerializedName("monto")
        @Expose
        private String monto;
        @SerializedName("saldo")
        @Expose
        private String saldo;
        @SerializedName("fecha")
        @Expose
        private String fecha;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getClienteId() {
            return clienteId;
        }

        public void setClienteId(Integer clienteId) {
            this.clienteId = clienteId;
        }

        public Integer getVentaId() {
            return ventaId;
        }

        public void setVentaId(Integer ventaId) {
            this.ventaId = ventaId;
        }

        public Integer getAcuerdoPagoId() {
            return acuerdoPagoId;
        }

        public void setAcuerdoPagoId(Integer acuerdoPagoId) {
            this.acuerdoPagoId = acuerdoPagoId;
        }

        public String getMonto() {
            return monto;
        }

        public void setMonto(String monto) {
            this.monto = monto;
        }

        public String getSaldo() {
            return saldo;
        }

        public void setSaldo(String saldo) {
            this.saldo = saldo;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
}
