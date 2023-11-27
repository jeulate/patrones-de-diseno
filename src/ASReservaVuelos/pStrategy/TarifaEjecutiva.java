package ASReservaVuelos.pStrategy;

public class TarifaEjecutiva implements Tarifa{
    @Override
    public double calcularPrecio() {
        return 250.0;
    }
}
