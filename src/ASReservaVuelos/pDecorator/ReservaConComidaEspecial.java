package ASReservaVuelos.pDecorator;

public class ReservaConComidaEspecial implements ReservaDeVuelo{
    private ReservaDeVuelo reservaBase;

    public ReservaConComidaEspecial(ReservaDeVuelo reservaBase) {
        this.reservaBase = reservaBase;
    }

    @Override
    public void reservaVuelo() {
        reservaBase.reservaVuelo();
        System.out.println("Añadiendo comida especial a la reserva.");
    }
}
