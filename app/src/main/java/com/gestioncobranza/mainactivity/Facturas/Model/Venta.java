package com.gestioncobranza.mainactivity.Facturas.Model;

import java.util.ArrayList;

public class Venta {

    int id;
    String cod;
    int vendedor_id;
    int cliente_id;
    String vendedor;
    String cliente;
    String tipo_venta;
    String abono;
    String descuentro;
    String periodo_pago;
    String cuotas;
    String total;
    ArrayList<ProductoFactura> productoFacturas;

    public Venta(int id, String cod, int vendedor_id, int cliente_id, String vendedor, String cliente, String tipo_venta, String abono, String descuentro, String periodo_pago, String cuotas, String total, ArrayList<ProductoFactura> productoFacturas) {
        this.id = id;
        this.cod = cod;
        this.vendedor_id = vendedor_id;
        this.cliente_id = cliente_id;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.tipo_venta = tipo_venta;
        this.abono = abono;
        this.descuentro = descuentro;
        this.periodo_pago = periodo_pago;
        this.cuotas = cuotas;
        this.total = total;
        this.productoFacturas = productoFacturas;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }

    public String getDescuentro() {
        return descuentro;
    }

    public void setDescuentro(String descuentro) {
        this.descuentro = descuentro;
    }

    public String getPeriodo_pago() {
        return periodo_pago;
    }

    public void setPeriodo_pago(String periodo_pago) {
        this.periodo_pago = periodo_pago;
    }

    public String getCuotas() {
        return cuotas;
    }

    public void setCuotas(String cuotas) {
        this.cuotas = cuotas;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<ProductoFactura> getProductoFacturas() {
        return productoFacturas;
    }

    public void setProductoFacturas(ArrayList<ProductoFactura> productoFacturas) {
        this.productoFacturas = productoFacturas;
    }
}
