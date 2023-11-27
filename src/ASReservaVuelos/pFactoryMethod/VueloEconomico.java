package ASReservaVuelos.pFactoryMethod;

import ASReservaVuelos.pFactoryMethod.Vuelo;

public class VueloEconomico implements Vuelo {
    @Override
    public void reservar() {
        System.out.println("Reserva de vuelo economico.");
    }
}
