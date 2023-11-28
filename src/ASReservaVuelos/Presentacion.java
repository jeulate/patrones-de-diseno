package ASReservaVuelos;

import ASReservaVuelos.pDecorator.*;
import ASReservaVuelos.pStrategy.Tarifa;
import ASReservaVuelos.pStrategy.TarifaEjecutiva;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class Presentacion {
    private JButton nuevaReservaButton;
    private JButton agregarTarifaButton;
    private JButton comidaEspecialButton;
    private JPanel panelhome;
    private JTextArea vistaReservas;
    private JButton asientoPreferencial;
    private JButton mostrarResultadosButton;
    private JRadioButton tarifaEconomicaRadioButton;
    private JRadioButton tarifaEjecutivaRadioButton;

    private ButtonGroup bTarifas;

    private ReservaDeVuelo reserva;
    private ReservaVueloEconomico vueloeco;


    public Presentacion() {
        vistaReservas.setText("Resumen de la Reserva:");
        nuevaReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserva =  new ReservaBasica();
                reserva.reservaVuelo();
                JOptionPane.showMessageDialog(null,"Estas iniciando una Reserva ");
            }
        });
        agregarTarifaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tarifa tarifaejecutiva = new TarifaEjecutiva();
                ((ReservaBasica) reserva).setTarifa(tarifaejecutiva);
                reserva.reservaVuelo();
                
            }
        });
        comidaEspecialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserva = new ReservaConComidaEspecial(reserva);
            }
        });
        asientoPreferencial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserva = new ReservaConAsientoPreferencial(reserva);
            }
        });

        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tarifaEconomicaRadioButton.isSelected()){
                    vistaReservas.append("Tarifa Economica Seleccionada \n" );
                } else if (tarifaEjecutivaRadioButton.isSelected()) {
                    vistaReservas.append("Tarifa Ejecutiva Seleccionada \n");
                }
            }
        };
        this.tarifaEconomicaRadioButton.addActionListener(radioListener);
        this.tarifaEjecutivaRadioButton.addActionListener(radioListener);
        mostrarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bTarifas = new ButtonGroup();
                bTarifas.add(tarifaEconomicaRadioButton);
                bTarifas.add(tarifaEjecutivaRadioButton);
                reserva.reservaVuelo();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Presentacion");
        frame.setContentPane(new Presentacion().panelhome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,500);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }
}
