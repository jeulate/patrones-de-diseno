package ASReservaVuelos;

import ASReservaVuelos.pStrategy.ITarifaBase;
import ASReservaVuelos.pStrategy.TarifaEconomica;
import ASReservaVuelos.pStrategy.TarifaBolvianos;

public class Main {
    public static void main(String[] args) {
        //Creamos una reserva de vuelo basica
        ReservaDeVuelo reserva = new ReservaBasica();

        //Agregamos servicios adicionales a la reserva
        reserva = new ReservaConComidaEspecial(reserva);
        reserva = new ReservaConAsientoPreferencial(reserva);

        //Realizar la reserva con la tarifa economica
        ITarifaBase tarifa = new TarifaBolvianos();
        double precio = tarifa.calcularPrecio();

        System.out.println("Resumen de la Reserva:");
        reserva.reservaVuelo();
        System.out.println("Precio Total $ "+ precio);

    }
}
