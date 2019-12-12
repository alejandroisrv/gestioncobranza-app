package com.gestioncobranza.mainactivity.DB;

import java.util.ArrayList;
import java.util.List;

import com.gestioncobranza.mainactivity.Facturas.Model.ProductoFactura;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FacturaDB {

    @SerializedName("VT")
    @Expose
    private ArrayList<Factura> vT = null;

    public ArrayList<Factura> getVT() {
        return vT;
    }

    public void setVT(ArrayList<Factura> vT) {
        this.vT = vT;
    }

    public class Factura{
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cod")
        @Expose
        private String cod;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("cliente_id")
        @Expose
        private Integer clienteId;
        @SerializedName("tipo_venta")
        @Expose
        private String tipoVenta;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("subtotal")
        @Expose
        private String subtotal;
        @SerializedName("abono")
        @Expose
        private String abono;
        @SerializedName("descuento")
        @Expose
        private String descuento;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("cuotas")
        @Expose
        private Integer cuotas;
        @SerializedName("periodo_pago")
        @Expose
        private String periodoPago;
        @SerializedName("nombre_vendedor")
        @Expose
        private String nombre_vendedor;
        @SerializedName("productos_venta")
        @Expose
        private ArrayList<ProductoFactura> productosVenta = null;
        @SerializedName("abonos")
        @Expose
        private ArrayList<Abono> abonos = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getClienteId() {
            return clienteId;
        }

        public void setClienteId(Integer clienteId) {
            this.clienteId = clienteId;
        }

        public String getTipoVenta() {
            return tipoVenta;
        }

        public void setTipoVenta(String tipoVenta) {
            this.tipoVenta = tipoVenta;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getAbono() {
            return abono;
        }

        public void setAbono(String abono) {
            this.abono = abono;
        }

        public String getDescuento() {
            return descuento;
        }

        public void setDescuento(String descuento) {
            this.descuento = descuento;
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

        public Integer getCuotas() {
            return cuotas;
        }

        public void setCuotas(Integer cuotas) {
            this.cuotas = cuotas;
        }

        public String getPeriodoPago() {
            return periodoPago;
        }

        public void setPeriodoPago(String periodoPago) {
            this.periodoPago = periodoPago;
        }

        public String getNombre_vendedor() {
            return nombre_vendedor;
        }

        public void setNombre_vendedor(String nombre_vendedor) {
            this.nombre_vendedor = nombre_vendedor;
        }

        public ArrayList<ProductoFactura> getProductosVenta() {
            return productosVenta;
        }

        public void setProductosVenta(ArrayList<ProductoFactura> productosVenta) {
            this.productosVenta = productosVenta;
        }

        public ArrayList<Abono> getAbonos() {
            return abonos;
        }

        public void setAbonos(ArrayList<Abono> abonos) {
            this.abonos = abonos;
        }
    }


    public class Abono {

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
