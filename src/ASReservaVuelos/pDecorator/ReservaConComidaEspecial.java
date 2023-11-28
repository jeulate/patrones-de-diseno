package ASReservaVuelos.pDecorator;

import ASReservaVuelos.pStrategy.Tarifa;
import ASReservaVuelos.pStrategy.TarifaEconomica;

public class ReservaConComidaEspecial implements ReservaDeVuelo{
    private ReservaDeVuelo reservaBase;
    private Tarifa tComidaespecial;

    public ReservaConComidaEspecial(Tarifa tComidaespecial) {
        this.tComidaespecial = tComidaespecial;
    }

    public ReservaConComidaEspecial(ReservaDeVuelo reservaBase) {
        this.reservaBase = reservaBase;
    }

    @Override
    public void reservaVuelo() {
        reservaBase.reservaVuelo();
        System.out.println("Añadiendo comida especial a la reserva.");
    }
}
