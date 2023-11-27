package ASReservaVuelos.pFactoryMethod;

public class VueloEjecutivo implements Vuelo{
    @Override
    public void reservar() {
        System.out.println("Reserva de vuelo ejecutivo.");
    }
}
