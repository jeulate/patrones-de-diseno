package ASReservaVuelos.pFactoryMethod;

import ASReservaVuelos.pStrategy.*;

import java.util.Date;

public abstract class Creator {
    private CalculadoraTarifa _calculadora;

    private ECity _cityOrigin;
    private ECity _cityFinal;
    private int _adultPassanger;
    private int _kidsPassanger;
    private Date _departureDate;
    private Date _returnDate;

    protected IDestinoVuelo CrearVuelo(ECity cityOrigin, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate) {
        return switch (_cityFinal) {
            case LA_PAZ -> new CreatorVueloLapaz()
                    .CrearVuelo(_cityOrigin, _adultPassanger, _kidsPassanger, _departureDate, _returnDate);
            case COCHABAMBA -> new CreatorVueloCochabamba()
                    .CrearVuelo(_cityOrigin, _adultPassanger, _kidsPassanger, _departureDate, _returnDate);
            case TARIJA -> new CreatorVueloTarija()
                    .CrearVuelo(_cityOrigin, _adultPassanger, _kidsPassanger, _departureDate, _returnDate);
        };
    }

    public double CalcularTotalVuelo(){
        IDestinoVuelo vuelo = this.CrearVuelo(_cityOrigin, _adultPassanger,_kidsPassanger,_departureDate,_returnDate);
        double monto = vuelo.calcularCargosVuelo();
        double total = _calculadora.calcularTarifaVuelo(monto);

        return total;
    }

    public void setParameter(ETarifa strategyTarifa, ECity cityOrigin, ECity cityFinal, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate){
        _calculadora = new CalculadoraTarifa();
        _calculadora.setStrategy(createStrategy(strategyTarifa));

        _cityOrigin = cityOrigin;
        _cityFinal = cityFinal;
        _adultPassanger = adultPassanger;
        _kidsPassanger = kidsPassanger;
        _departureDate = departureDate;
        _returnDate =returnDate;
    }
    private ITarifaBase createStrategy(ETarifa  strategy){
        return switch (strategy) {
            case DOLLARS -> new TarifaDollars();
            case BOLIVIANOS -> new TarifaBolvianos();
            case PESOS_ARGENTINOS -> new TarifaPesosArgentinos();
        };
    }
}
