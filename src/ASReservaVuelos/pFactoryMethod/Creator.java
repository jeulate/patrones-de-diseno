package ASReservaVuelos.pFactoryMethod;

import ASReservaVuelos.pStrategy.*;

import java.util.Date;

public abstract class Creator {
    private IDestinoVuelo _vuelo;
    private CalculadoraTarifa _calculadora;

    private ECity _cityOrigin;
    private int _adultPassanger;
    private int _kidsPassanger;
    private Date _departureDate;
    private Date _returnDate;

    protected abstract IDestinoVuelo CrearVuelo(ECity cityOrigin, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate);

    private IDestinoVuelo CrearDestino(ECity cityFinal) {
        return switch (cityFinal) {
            case LA_PAZ -> new CreatorVueloLapaz()
                    .CrearVuelo(_cityOrigin, _adultPassanger, _kidsPassanger, _departureDate, _returnDate);
            case COCHABAMBA -> new CreatorVueloCochabamba()
                    .CrearVuelo(_cityOrigin, _adultPassanger, _kidsPassanger, _departureDate, _returnDate);
            case TARIJA -> new CreatorVueloTarija()
                    .CrearVuelo(_cityOrigin, _adultPassanger, _kidsPassanger, _departureDate, _returnDate);
        };
    }

    public double CalcularTotalVuelo(ECity cityFinal){
        IDestinoVuelo vuelo = this.CrearDestino(cityFinal);
        double monto = vuelo.calcularCargosVuelo();
        double total = _calculadora.calcularTarifaVuelo(monto);

        return total;
    }

    public void setParameter(ETarifa strategyTarifa, ECity cityOrigin, ECity cityFinal, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate){
        _calculadora = new CalculadoraTarifa();
        _calculadora.setStrategy(createStrategy(strategyTarifa));

        _cityOrigin = cityOrigin;
        _adultPassanger = adultPassanger;
        _kidsPassanger = kidsPassanger;
        _departureDate = departureDate;
        _returnDate =returnDate;

        _vuelo = CrearDestino(cityFinal);
    }
    private ITarifaBase createStrategy(ETarifa  strategy){
        return switch (strategy) {
            case DOLLARS -> new TarifaDollars();
            case BOLIVIANOS -> new TarifaBolvianos();
            case PESOS_ARGENTINOS -> new TarifaPesosArgentinos();
        };
    }
}
