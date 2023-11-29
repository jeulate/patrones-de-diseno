package ASReservaVuelos.pStrategy;

public class TarifaDollars implements ITarifaBase {
    private double _factorConversion;
    private double _impuesto;
    public  TarifaDollars(){
        _factorConversion =1;
        _impuesto = 72;
    }
    @Override
    public double calcularMontoTarifa(double monto) {
        return (monto * _factorConversion) + _impuesto;
    }
}
