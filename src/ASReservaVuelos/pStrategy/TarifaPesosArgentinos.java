package ASReservaVuelos.pStrategy;

public class TarifaPesosArgentinos implements ITarifaBase{
    private double _factorConversion;
    private double _impuesto;
    public  TarifaPesosArgentinos(){
        _factorConversion = 1230;
        _impuesto = 369;
    }
    @Override
    public double calcularMontoTarifa(double monto) {
        return (monto * _factorConversion) + _impuesto;
    }
}
