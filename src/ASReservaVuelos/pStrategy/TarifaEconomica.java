package ASReservaVuelos.pStrategy;

public class TarifaEconomica implements Tarifa{
    @Override
    public double calcularPrecio() {
        return 100.0;
    }
}
