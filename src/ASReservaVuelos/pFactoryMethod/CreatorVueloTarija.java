package ASReservaVuelos.pFactoryMethod;

import java.util.Date;

public class CreatorVueloTarija extends Creator {
    private double _base;
    private double _precioAdults;
    private double _precioKids;
    private double _precioDay;

    public  CreatorVueloTarija(){
        super();
        _base = 500;
        _precioAdults = 8;
        _precioKids = 3;
        _precioDay = 7;
    }
    @Override
    protected IDestinoVuelo CrearVuelo(ECity cityOrigin, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate) {
        VueloTarija _vueloTarija = new VueloTarija(cityOrigin, adultPassanger, kidsPassanger, departureDate, returnDate);
        _vueloTarija.setParameters(_base, _precioAdults, _precioKids, _precioDay);
        return  _vueloTarija;
    }
}
