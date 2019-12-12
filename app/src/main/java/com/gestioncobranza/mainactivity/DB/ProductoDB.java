package com.gestioncobranza.mainactivity.DB;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductoDB {

    @SerializedName("PD")
    @Expose
    private ArrayList<Entrega> PD = null;

    public ArrayList<Entrega> getPD() {
        return this.PD;
    }

    public void setVT(ArrayList<Entrega> vT) {
        this.PD = vT;
    }

    public class Entrega {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("vendedor_id")
        @Expose
        private Integer vendedorId;
        @SerializedName("bodega_id")
        @Expose
        private Integer bodegaId;
        @SerializedName("comentario")
        @Expose
        private String comentario;
        @SerializedName("estado")
        @Expose
        private Integer estado;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("itemProductoEntregas")
        @Expose
        private ArrayList<ItemProductoEntrega> itemProductoEntregas = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getVendedorId() {
            return vendedorId;
        }

        public void setVendedorId(Integer vendedorId) {
            this.vendedorId = vendedorId;
        }

        public Integer getBodegaId() {
            return bodegaId;
        }

        public void setBodegaId(Integer bodegaId) {
            this.bodegaId = bodegaId;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        public Integer getEstado() {
            return estado;
        }

        public void setEstado(Integer estado) {
            this.estado = estado;
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

        public ArrayList<ItemProductoEntrega> getItemProductoEntregas() {
            return itemProductoEntregas;
        }

        public void setItemProductoEntregas(ArrayList<ItemProductoEntrega> itemProductoEntregas) {
            this.itemProductoEntregas = itemProductoEntregas;
        }

    }

    public class ItemProductoEntrega {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("producto_id")
        @Expose
        private Integer productoId;
        @SerializedName("detalle")
        @Expose
        private Integer detalle;
        @SerializedName("producto")
        @Expose
        private Producto producto;
        @SerializedName("cantidad")
        @Expose
        private Integer cantidad;
        @SerializedName("estado")
        @Expose
        private int estado;
        @SerializedName("comentario")
        @Expose
        private String comentario;
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

        public Integer getProductoId() {
            return productoId;
        }

        public void setProductoId(Integer productoId) {
            this.productoId = productoId;
        }

        public Integer getDetalle() {
            return detalle;
        }

        public void setDetalle(Integer detalle) {
            this.detalle = detalle;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
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
    public class Producto {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("bodega_id")
        @Expose
        private Integer bodegaId;
        @SerializedName("sucursal_id")
        @Expose
        private Integer sucursalId;
        @SerializedName("cod")
        @Expose
        private String cod;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;
        @SerializedName("tipo_id")
        @Expose
        private Integer tipoId;
        @SerializedName("precio_costo")
        @Expose
        private String precioCosto;
        @SerializedName("precio_credito")
        @Expose
        private String precioCredito;
        @SerializedName("precio_contado")
        @Expose
        private String precioContado;
        @SerializedName("imagen")
        @Expose
        private String imagen;
        @SerializedName("comision")
        @Expose
        private String comision;
        @SerializedName("cantidad")
        @Expose
        private Integer cantidad;
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

        public Integer getBodegaId() {
            return bodegaId;
        }

        public void setBodegaId(Integer bodegaId) {
            this.bodegaId = bodegaId;
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

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Integer getTipoId() {
            return tipoId;
        }

        public void setTipoId(Integer tipoId) {
            this.tipoId = tipoId;
        }

        public String getPrecioCosto() {
            return precioCosto;
        }

        public void setPrecioCosto(String precioCosto) {
            this.precioCosto = precioCosto;
        }

        public String getPrecioCredito() {
            return precioCredito;
        }

        public void setPrecioCredito(String precioCredito) {
            this.precioCredito = precioCredito;
        }

        public String getPrecioContado() {
            return precioContado;
        }

        public void setPrecioContado(String precioContado) {
            this.precioContado = precioContado;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getComision() {
            return comision;
        }

        public void setComision(String comision) {
            this.comision = comision;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
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
