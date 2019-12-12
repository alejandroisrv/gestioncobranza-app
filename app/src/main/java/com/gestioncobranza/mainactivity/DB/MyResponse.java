package com.gestioncobranza.mainactivity.DB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyResponse {

    public class logout{

            @SerializedName("success")
            @Expose
            private Boolean success;

            public Boolean getSuccess() {
                return success;
            }

            public void setSuccess(Boolean success) {
                this.success = success;
            }
    }

    public class data {

        @SerializedName("productos")
        @Expose
        private List<ProductoDB.Entrega> productos = null;
        @SerializedName("rutas")
        @Expose
        private List<RutaDB.Ruta> rutas = null;
        @SerializedName("ventas")
        @Expose
        private List<FacturaDB.Factura> ventas = null;
        @SerializedName("cobros")
        @Expose
        private List<CobroDB.Cobro> cobros = null;
        @SerializedName("clientes")
        @Expose
        private List<ClienteDB.Clientes> clientes = null;

        public List<ProductoDB.Entrega> getProductos() {
            return productos;
        }

        public void setProductos(List<ProductoDB.Entrega> productos) {
            this.productos = productos;
        }

        public List<RutaDB.Ruta> getRutas() {
            return rutas;
        }

        public void setRutas(List<RutaDB.Ruta> rutas) {
            this.rutas = rutas;
        }

        public List<FacturaDB.Factura> getVentas() {
            return ventas;
        }

        public void setVentas(List<FacturaDB.Factura> ventas) {
            this.ventas = ventas;
        }

        public List<CobroDB.Cobro> getCobros() {
            return cobros;
        }

        public void setCobros(List<CobroDB.Cobro> cobros) {
            this.cobros = cobros;
        }

        public List<ClienteDB.Clientes> getClientes() {
            return clientes;
        }

        public void setClientes(List<ClienteDB.Clientes> clientes) {
            this.clientes = clientes;
        }
    }
}
