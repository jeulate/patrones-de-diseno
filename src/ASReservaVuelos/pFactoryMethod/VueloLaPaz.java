package ASReservaVuelos.pFactoryMethod;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class VueloLaPaz implements IDestinoVuelo {
    private ECity _cityOrigin;
    private int _adultPassanger;
    private int _kidsPassanger;
    private Date _departureDate;
    private Date _returnDate;

    private double _base;
    private double _precioAdults;
    private double _precioKids;
    private double _precioDay;

    public VueloLaPaz(ECity cityOrigin, int adultPassanger,int kidsPassanger, Date departureDate, Date returnDate){
        _cityOrigin = cityOrigin;
        _adultPassanger = adultPassanger;
        _kidsPassanger = kidsPassanger;
        _departureDate = departureDate;
        _returnDate = returnDate;
    }

    public void setBase(double _base) {
        this._base = _base;
    }

    public void setPrecioAdults(double _precioAdults) {
        this._precioAdults = _precioAdults;
    }

    public void setPrecioKids(double _precioKids) {
        this._precioKids = _precioKids;
    }

    public void setPrecioDay(double _precioDay) {
        this._precioDay = _precioDay;
    }

    public void setParameters(double base, double precioAdults, double precioKids, double precioDay){
        setBase(base);
        setPrecioAdults(precioAdults);
        setPrecioKids(precioKids);
        setPrecioDay(precioDay);
    }
    @Override
    public double calcularCargosVuelo() {
        double total = 0;
        // Calcula la diferencia en milisegundos
        long differenceInMilliseconds = _departureDate.getTime() - _returnDate.getTime();

        // Convierte la diferencia de milisegundos a días
        long qDays = TimeUnit.MILLISECONDS.toDays(differenceInMilliseconds);

        total = total + _base + (_adultPassanger * _precioAdults) + (_kidsPassanger * _precioKids) + (qDays * _precioDay);
        return total;
    }

}
