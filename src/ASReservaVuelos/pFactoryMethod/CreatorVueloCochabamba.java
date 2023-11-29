package ASReservaVuelos.pFactoryMethod;

import java.util.Date;

public class CreatorVueloCochabamba extends Creator{
    private double _base;
    private double _precioAdults;
    private double _precioKids;
    private double _precioDay;

    public  CreatorVueloCochabamba(){
        super();
        _base = 750;
        _precioAdults = 12;
        _precioKids = 7;
        _precioDay = 5;
    }
    @Override
    protected IDestinoVuelo CrearVuelo(ECity cityOrigin, int adultPassanger, int kidsPassanger, Date departureDate, Date returnDate) {
        VueloCochabamba _vueloCochabamba = new VueloCochabamba(cityOrigin, adultPassanger, kidsPassanger, departureDate, returnDate);
        _vueloCochabamba.setParameters(_base, _precioAdults, _precioKids, _precioDay);
        return  _vueloCochabamba;
    }
}
