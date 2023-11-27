package ASReservaVuelos.pDecorator;

public class ReservaConAsientoPreferencial implements ReservaDeVuelo{
    private ReservaDeVuelo reservaBase;

    public ReservaConAsientoPreferencial(ReservaDeVuelo reservaBase) {
        this.reservaBase = reservaBase;
    }

    @Override
    public void reservaVuelo() {
        reservaBase.reservaVuelo();
        System.out.println("Seleccionando asiento preferencial.");
    }
}
