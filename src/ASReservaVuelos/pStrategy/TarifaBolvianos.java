package ASReservaVuelos.pStrategy;

public class TarifaBolvianos implements ITarifaBase {
    private double _impuesto;
    private double _factorConversion;
    public TarifaBolvianos(){
        _factorConversion = 6.86;
        _impuesto = 500;
    }
    @Override
    public double calcularMontoTarifa(double monto) {
        return (monto * _factorConversion) + _impuesto;
    }
}
