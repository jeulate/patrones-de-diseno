package ASReservaVuelos.pDecorator;

import ASReservaVuelos.pStrategy.Tarifa;
import ASReservaVuelos.pStrategy.TarifaEconomica;

import javax.swing.*;

public class ReservaBasica implements ReservaDeVuelo{

    private Tarifa tarifa;

    public ReservaBasica(){
        this.tarifa = new TarifaEconomica();
    }
    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
    public Tarifa getTarifa() {
        return tarifa;
    }


    @Override
    public void reservaVuelo() {
        System.out.println("Reserva basica de vuelo con " + getTarifa().getClass().getSimpleName());
        double precio = tarifa.calcularPrecio();
        System.out.println("Precio total: $ "+precio);

    }
}
