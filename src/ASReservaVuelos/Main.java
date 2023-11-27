package ASReservaVuelos;

import ASReservaVuelos.pDecorator.ReservaBasica;
import ASReservaVuelos.pDecorator.ReservaConAsientoPreferencial;
import ASReservaVuelos.pDecorator.ReservaConComidaEspecial;
import ASReservaVuelos.pDecorator.ReservaDeVuelo;
import ASReservaVuelos.pStrategy.Tarifa;
import ASReservaVuelos.pStrategy.TarifaEconomica;
import ASReservaVuelos.pStrategy.TarifaEjecutiva;

public class Main {
    public static void main(String[] args) {
        //Creamos una reserva de vuelo basica
        ReservaDeVuelo reserva = new ReservaBasica();

        //Agregamos servicios adicionales a la reserva
        reserva = new ReservaConComidaEspecial(reserva);
        reserva = new ReservaConAsientoPreferencial(reserva);

        //Realizar la reserva con la tarifa economica
        Tarifa tarifa = new TarifaEjecutiva();
        double precio = tarifa.calcularPrecio();

        System.out.println("Resumen de la Reserva:");
        reserva.reservaVuelo();
        System.out.println("Precio Total $ "+ precio);

    }
}
