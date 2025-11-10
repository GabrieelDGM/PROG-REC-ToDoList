package net.salesianos.recuperacion.listas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormTarea extends JFrame {
    public FormTarea(Queue<Tarea> listaTareas) {

        // Creanos el titulo de la ventana
        setTitle("Añadir una tarea");
        // Tamaño de la ventana
        setSize(300, 250);
        // Centrar pantalla
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 80, 20);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(100, 20, 200, 20);
        add(txtTitulo);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(20, 60, 80, 20);
        add(lblDescripcion);

        JTextField txtDescripcion = new JTextField();
        txtDescripcion.setBounds(100, 60, 200, 20);
        add(txtDescripcion);

        JLabel lblPrioridad = new JLabel("Prioridad:");
        lblPrioridad.setBounds(20, 100, 80, 20);
        add(lblPrioridad);

        JComboBox<String> cmbPrioridad = new JComboBox<>();
        cmbPrioridad.addItem("Alta");
        cmbPrioridad.addItem("Media");
        cmbPrioridad.addItem("Baja");
        cmbPrioridad.setBounds(100, 100, 100, 20);
        add(cmbPrioridad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 140, 100, 25);
        add(btnGuardar);

         //Evento del botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String titulo = txtTitulo.getText().trim();
                String descripcion = txtDescripcion.getText().trim();
                String prioridad = (String) cmbPrioridad.getSelectedItem();

                if (titulo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
                    return;
                }

                LocalDate fecha = LocalDate.now();
                Tarea nueva = new Tarea(titulo, descripcion, prioridad, fecha);
                listaTareas.add(nueva);

                JOptionPane.showMessageDialog(null, "Tarea añadida");
                dispose();
            }
        });

        setVisible(true);

    }
}