package com.gestioncobranza.mainactivity.Productos.Model;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Productos.Producto;

public class ProductosInteractor implements Producto.interactor {


    private final EntregadasRepository entradasRepository;
    private final Producto.productosRepository productosRepository;

    public ProductosInteractor(Producto.presenter productosPresenter) {
        this.entradasRepository = new EntregadasRepository(productosPresenter);
        this.productosRepository = new ProductosRepository(productosPresenter);

    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        entradasRepository.getDatosApi(onResult);
    }

    @Override
    public void syncData() {

    }

    @Override
    public void getEntregas() {
        entradasRepository.getEntregas();
    }

    @Override
    public void getProductos(String query) {
        productosRepository.getProductos(query);
    }

    @Override
    public void getEntrega(int id) {
        entradasRepository.getEntrega(id);
    }

    @Override
    public void getProducto(int id) {
      productosRepository.getProducto(id);
    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {

    }

    @Override
    public void getItem(int id) {

    }
}
