package ASReservaVuelos.pFactoryMethod;

import ASReservaVuelos.pStrategy.ETarifa;

import java.util.Date;

public class CreatorVueloLapaz  extends Creator{
    private double _base;
    private double _precioAdults;
    private double _precioKids;
    private double _precioDay;

    public  CreatorVueloLapaz(){
        super();
        _base = 800;
        _precioAdults = 10;
        _precioKids = 5;
        _precioDay = 4;
    }
    @Override
    protected IDestinoVuelo CrearVuelo(ECity cityOrigin, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate) {
        VueloLaPaz _vueloLaPaz = new VueloLaPaz(cityOrigin, adultPassanger, kidsPassanger, departureDate, returnDate);
        _vueloLaPaz.setParameters(_base, _precioAdults, _precioKids, _precioDay);
        return  _vueloLaPaz;
    }
}
