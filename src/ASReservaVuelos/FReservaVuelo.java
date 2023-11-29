package ASReservaVuelos;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

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

    private JDateChooser fechaIdaChosser;
    private JDateChooser fechaVueltaChosser;

    public FReservaVuelo() {
        fechaIdaChosser =  new JDateChooser();
        fechaVueltaChosser =  new JDateChooser();
        fechaIdaPanel.add(fechaIdaChosser);
        fechaVueltaPanel.add(fechaVueltaChosser);
//        paintCiudades(origenComboBox, null, null);
//        paintCiudades(destinoComboBox, null, null);

//        paintMonedas();
//        origenComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                changeCombo(origenComboBox, destinoComboBox);
//            }
//        });
//        destinoComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                changeCombo(destinoComboBox, origenComboBox);
//            }
//        });
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


    static final String[] destinos = {"Santa Cruz", "Cochabamba", "La Paz"};

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

    static final String[] monedas = {"Dolares", "Bolivianos", "Pesos"};

    private void paintMonedas() {
        for (int i = 0; i < monedas.length; i++) {
            monedaComboBox.addItem(monedas[i]);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Reserva de Vuelo");
        frame.setContentPane(new FReservaVuelo().jPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
