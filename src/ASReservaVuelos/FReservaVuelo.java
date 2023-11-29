package ASReservaVuelos;

import ASReservaVuelos.pDecorator.ConfigurationNotifier;
import ASReservaVuelos.pFactoryMethod.Creator;
import ASReservaVuelos.pFactoryMethod.ECity;
import ASReservaVuelos.pStrategy.ETarifa;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FReservaVuelo {
    private JCheckBox reservaComidaEspecialCheckBox;
    private JCheckBox equipajePrefenrencialCheckBox;
    private JCheckBox asientoPreferencialCheckBox;
    private JComboBox monedaComboBox;
    private JPanel jPanelPrincipal;
    private JComboBox origenComboBox;
    private JComboBox destinoComboBox;
    private JLabel totalLabel;
    private JTextField adultoTextField;
    private JTextField ninoTextField;
    private JTextField bebeTextField;
    private JRadioButton idaYVueltaRadioButton;
    private JRadioButton soloIdaRadioButton;
    private JPanel fechaIdaPanel;
    private JPanel fechaVueltaPanel;
    private JCheckBox enviarEmailCheckBox;
    private JCheckBox enviarSMSCheckBox;
    private JButton reservarButton;

    private JDateChooser fechaIdaChosser;
    private JDateChooser fechaVueltaChosser;

    private static final String origenDefault = "Santa Cruz";


    private Creator creator;
    private ConfigurationNotifier notifier;

    public FReservaVuelo() {
        creator =  new Creator();
        fechaIdaChosser =  new JDateChooser(new Date());
        fechaVueltaChosser =  new JDateChooser(new Date());
        fechaIdaPanel.add(fechaIdaChosser);
        fechaVueltaPanel.add(fechaVueltaChosser);
        adultoTextField.setText("1");
        ninoTextField.setText("0");
        reservarButton.setEnabled(false);
        origenComboBox.addItem(origenDefault);
        //paintCiudades(origenComboBox, null, null);
        paintCiudades(destinoComboBox, null, origenDefault);
        paintMonedas();
//        origenComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                changeCombo(origenComboBox, destinoComboBox);
//            }
//        });
        destinoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //changeCombo(destinoComboBox, origenComboBox);
                calcularTotal();
            }
        });
        monedaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        fechaIdaChosser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    calcularTotal();
                }
            }
        });

        fechaVueltaChosser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    calcularTotal();
                }
            }
        });
        adultoTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calcularTotal();
                }
            }
        });
        ninoTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calcularTotal();
                }
            }
        });
        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservar();
            }
        });
    }

    private void changeCombo(JComboBox jComboBoxChange, JComboBox jComboBoxRepaint) {
        String seleccionadoChange = (String) jComboBoxChange.getSelectedItem();
        String seleccionadoRepaint = (String) jComboBoxRepaint.getSelectedItem();
        jComboBoxRepaint.removeAllItems();
        paintCiudades(jComboBoxRepaint, seleccionadoRepaint, seleccionadoChange);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    private void paintCiudades(JComboBox jComboBox, String ciudadSeleccionada, String ciudadOcultar) {
        jComboBox.addItem("");
        for (int i = 0; i < destinos.length; i++) {
            if (ciudadOcultar != null && ciudadOcultar.equals(destinos[i])) {
                continue;
            }
            jComboBox.addItem(destinos[i]);
        }
        if(ciudadSeleccionada != null) {
            jComboBox.setSelectedItem(ciudadSeleccionada);
        }
    }

    private void calcularTotal() {
        totalLabel.setText("$us. XXX.XX");
        reservarButton.setEnabled(false);
        String monedaSeleccionada = (String) monedaComboBox.getSelectedItem();
        ETarifa strategyTarifa =  getETarifa(monedaSeleccionada);
        if(strategyTarifa == null) {
            JOptionPane.showMessageDialog(null, "Error al escoger la moneda");
        }
        ECity cityOrigin = ECity.SANTA_CRUZ;
        ECity cityFinal = getECity((String) destinoComboBox.getSelectedItem());
        if(cityFinal == null) {
            JOptionPane.showMessageDialog(null, "Error al escoger el destino");
            return;
        }
        int adultPassanger, kidsPassanger;
        try {
            adultPassanger = Integer.parseInt(adultoTextField.getText());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "La cantidad de Adultos debe ser un numero");
            return;
        }
        try {
            kidsPassanger = Integer.parseInt(ninoTextField.getText());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "La cantidad de Niños debe ser un numero");
            return;
        }
        if(adultPassanger < 1) {
            JOptionPane.showMessageDialog(null, "La cantidad de Adultos debe ser un mayor o igual a uno");
            return;
        }
        if(kidsPassanger < 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de Niños debe ser un mayor o igual a cero");
            return;
        }

        Date departureDate = fechaIdaChosser.getDate();
        if(departureDate == null) {
            JOptionPane.showMessageDialog(null, "No selecciono La fecha de salida");
            return;
        }
        Date returnDate = fechaVueltaChosser.getDate();
        if(returnDate == null) {
            JOptionPane.showMessageDialog(null, "No selecciono La fecha de regreso");
            return;
        }

        if(departureDate.compareTo(returnDate) > 0) {
            JOptionPane.showMessageDialog(null, "La fecha de salida no puede ser mayor a la fecha de regreso");
            return;
        }

        creator.setParameter(strategyTarifa, cityOrigin, cityFinal, adultPassanger, kidsPassanger, departureDate, returnDate);
        double totalVuelo = creator.CalcularTotalVuelo();

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("#,###.00");
        String totalVueloFormat = getSimboloMoneda(monedaSeleccionada)  + " " + decimalFormat.format(totalVuelo);
        totalLabel.setText(totalVueloFormat);
        reservarButton.setEnabled(true);
    }

    // Monedas ---------------------------------
    static final String[] monedas = {"Dolares", "Bolivianos", "Pesos"};
    private void paintMonedas() {
        for (int i = 0; i < monedas.length; i++) {
            monedaComboBox.addItem(monedas[i]);
        }
    }
    private ETarifa getETarifa(String moneda) {
        switch (moneda) {
            case "Dolares" :
                return ETarifa.DOLLARS;
            case "Bolivianos" :
                return ETarifa.BOLIVIANOS;
            case "Pesos" :
                return ETarifa.PESOS_ARGENTINOS;
            default:
                return null;
        }
    }
    private String getSimboloMoneda(String moneda) {
        switch (moneda) {
            case "Dolares" :
                return "$us.";
            case "Bolivianos" :
                return "Bs.";
            case "Pesos" :
                return "Ars.";
            default:
                return null;
        }
    }

    // Destinos  ---------------------------------
    static final String[] destinos = {"Tarija", "Cochabamba", "La Paz"};
    private ECity getECity(String ciudad) {
        switch (ciudad) {
            case "Tarija" :
                return ECity.TARIJA;
            case "Cochabamba" :
                return ECity.COCHABAMBA;
            case "La Paz" :
                return ECity.LA_PAZ;
            default:
                return null;
        }
    }

    public String getDatosReserva() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String reserva = "************ Reserva de Vuelo ************\n";
        reserva += "Ciudad Origen: " + origenComboBox.getSelectedItem() + "\n";
        reserva += "Ciudad Destino: " + destinoComboBox.getSelectedItem() + "\n";
        reserva += "Fecha Salida: " + dateFormat.format(fechaIdaChosser.getDate()) + "\n";
        reserva += "Fecha Regreso: " + dateFormat.format(fechaVueltaChosser.getDate()) + "\n";
        reserva += "Cantidad de Adultos: " + adultoTextField.getText() + "\n";
        reserva += "Cantidad de Niños: " + ninoTextField.getText() + "\n";
        reserva += "------------------------------------------\n";
        reserva += "Total: " + totalLabel.getText() + "\n";
        reserva += "******************************************\n";
        return reserva;
    }

    private void reservar() {
        boolean enviarEmail = enviarEmailCheckBox.isSelected();
        boolean enviarSMS = enviarSMSCheckBox.isSelected();
        notifier =  new ConfigurationNotifier(enviarEmail, enviarSMS);
        notifier.SendNotification(getDatosReserva());
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Reserva de Vuelo");
        frame.setContentPane(new FReservaVuelo().jPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
