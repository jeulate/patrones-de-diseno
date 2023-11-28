package ASReservaVuelos.pDecorator;

import ASReservaVuelos.pFactoryMethod.Vuelo;
import ASReservaVuelos.pFactoryMethod.VueloEconomico;
import ASReservaVuelos.pStrategy.Tarifa;
import ASReservaVuelos.pStrategy.TarifaEconomica;

public class ReservaVueloEconomico {
    private Tarifa tarifa;
    private Vuelo vuelo;

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public ReservaVueloEconomico() {
        this.tarifa = new TarifaEconomica();
        this.vuelo = new VueloEconomico();
    }

    public void reservarVuelo(){
        vuelo.reservar();
        double precio = tarifa.calcularPrecio();
        System.out.println("Precio total de la reserva: $"+precio);
    }
}
