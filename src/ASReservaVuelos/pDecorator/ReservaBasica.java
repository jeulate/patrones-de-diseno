package ASReservaVuelos.pDecorator;

public class ReservaBasica implements ReservaDeVuelo{
    @Override
    public void reservaVuelo() {
        System.out.println("Reserva basica de vuelo.");
    }
}
