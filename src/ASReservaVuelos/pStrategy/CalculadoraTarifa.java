package ASReservaVuelos.pStrategy;

public class CalculadoraTarifa {
    private ITarifaBase _tarifa;

    public void setStrategy(ITarifaBase tarifa){
        _tarifa = tarifa;
    }
    public double calcularTarifaVuelo(double monto){
        return _tarifa.calcularMontoTarifa(monto);
    }

}
