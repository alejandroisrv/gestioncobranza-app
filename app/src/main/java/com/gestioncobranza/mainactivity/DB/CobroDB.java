package com.gestioncobranza.mainactivity.DB;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CobroDB {

    @SerializedName("CB")
    @Expose
    private ArrayList<Cobro> cb = null;

    public ArrayList<Cobro> getCb() {
        return cb;
    }

    public void setCb(ArrayList<Cobro> cb) {
        this.cb = cb;
    }

    public class Cobro {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("ruta_id")
        @Expose
        private Integer rutaId;
        @SerializedName("estado")
        @Expose
        private Integer estado;
        @SerializedName("comision")
        @Expose
        private String comision;
        @SerializedName("fecha_inicio")
        @Expose
        private String fechaInicio;
        @SerializedName("fecha_culminacion")
        @Expose
        private String fechaCulminacion;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("cobroItems")
        @Expose
        private ArrayList<CobroItem> cobroItems = new ArrayList<>();

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getRutaId() {
            return rutaId;
        }

        public void setRutaId(Integer rutaId) {
            this.rutaId = rutaId;
        }

        public Integer getEstado() {
            return estado;
        }

        public void setEstado(Integer estado) {
            this.estado = estado;
        }

        public String getComision() {
            return comision;
        }

        public void setComision(String comision) {
            this.comision = comision;
        }

        public String getFechaInicio() {
            return fechaInicio;
        }

        public void setFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public String getFechaCulminacion() {
            return fechaCulminacion;
        }

        public void setFechaCulminacion(String fechaCulminacion) {
            this.fechaCulminacion = fechaCulminacion;
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

        public ArrayList<CobroItem> getCobroItems() {
            return cobroItems;
        }

        public void setCobroItems(ArrayList<CobroItem> cobroItems) {
            this.cobroItems = cobroItems;
        }

    }

    public class CobroItem {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cobro_id")
        @Expose
        private Integer cobroId;
        @SerializedName("ruta_item_id")
        @Expose
        private Integer rutaItemId;
        @SerializedName("acuerdo_pago_id")
        @Expose
        private Integer acuerdoPagoId;
        @SerializedName("monto")
        @Expose
        private String monto;
        @SerializedName("comision")
        @Expose
        private String comision;
        @SerializedName("estado")
        @Expose
        private Integer estado;
        @SerializedName("observacion")
        @Expose
        private String observacion;
        @SerializedName("fecha_culminacion")
        @Expose
        private String fechaCulminacion;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCobroId() {
            return cobroId;
        }

        public void setCobroId(Integer cobroId) {
            this.cobroId = cobroId;
        }

        public Integer getRutaItemId() {
            return rutaItemId;
        }

        public void setRutaItemId(Integer rutaItemId) {
            this.rutaItemId = rutaItemId;
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

        public String getComision() {
            return comision;
        }

        public void setComision(String comision) {
            this.comision = comision;
        }

        public Integer getEstado() {
            return estado;
        }

        public void setEstado(Integer estado) {
            this.estado = estado;
        }

        public String getObservacion() {
            return observacion;
        }

        public void setObservacion(String observacion) {
            this.observacion = observacion;
        }

        public String getFechaCulminacion() {
            return fechaCulminacion;
        }

        public void setFechaCulminacion(String fechaCulminacion) {
            this.fechaCulminacion = fechaCulminacion;
        }

    }
}
