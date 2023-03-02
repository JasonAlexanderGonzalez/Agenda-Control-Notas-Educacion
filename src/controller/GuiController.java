package controller;

import model.Examen;
import model.Lista;
import view.Gui;
import view.Ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GuiController implements ActionListener {

    private Lista list;
    private Gui gui;
    DefaultTableModel tblModel = new DefaultTableModel();

    public GuiController() {
        list = new Lista();
        gui = new Gui();

        initEvents();
        header();
        gui.setVisible(true);
        gui.setTitle("Examen");
        gui.setResizable(false);

    }

    public void initEvents() {
        gui.getBtnAdd().addActionListener(this);
        gui.getBtnDelete().addActionListener(this);
        gui.getBtnGetList().addActionListener(this);
        gui.getBtnUpdate().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == gui.getBtnAdd()) {
            add();
        }
        if (e.getSource() == gui.getBtnGetList()) {
            data();
        }
        if (e.getSource() == gui.getBtnDelete()) {
            toDelete();
        }
        if (e.getSource() == gui.getBtnUpdate()) {
            toUpdate();
        }
    }

    public void header() {
        Object[] head = {"Consecutivo", "Fecha", "Puntaje", "Porcentaje"};
        tblModel.setColumnIdentifiers(head);
        gui.getTblTable().setModel(tblModel);
    }

    public void add() {
        if (gui.getTxtFecha().isEmpty() || gui.getTxtPuntos().isEmpty()
                || gui.getTxtPorcentaje().isEmpty()) {
            Ui.write("Por favor, complete las casillas");
        } else {
            String date = gui.getTxtFecha();
            int points = Integer.parseInt(gui.getTxtPuntos());
            double porcent = Double.parseDouble(gui.getTxtPorcentaje());
            if (list.validate(date)) {
                Ui.write("Fecha repetida, por favor ingresa una diferente");
                gui.setTxtFecha("");
                gui.setTxtPuntos("");
                gui.setTxtPorcentaje("");
            } else {
                if (list.add(new Examen(date, points, porcent))) {
                    Ui.write("Se ha agregado el examen exitosamente");
                    gui.setTxtFecha("");
                    gui.setTxtPuntos("");
                    gui.setTxtPorcentaje("");
                    data();

                } else {
                    Ui.write("No se logro agregar el examen");
                }
            }
        }
    }

    public DefaultTableModel toDelete() {
        DefaultTableModel tb1Model = (DefaultTableModel) gui.getTblTable().getModel();
        if (gui.getTblTable().getSelectedRowCount() == 1) {
            tb1Model.removeRow(gui.getTblTable().getSelectedRow());
            return tb1Model;

        } else {
            if (gui.getTblTable().getRowCount() == 0) {
                JOptionPane.showMessageDialog(gui, "Error, Tabla vacia");
            } else {
                Ui.write("Por favor, selecciona una fila a eliminar");
            }
        }
        return null;
    }

    public void data() {
        Object[] containData = new Object[tblModel.getColumnCount()];
        int i = 1;
        tblModel.setRowCount(0);
        for (int j = 0; j < list.getList().size(); j++) {
            containData[0] = i;
            containData[1] = list.getList().get(j).getDate();
            containData[2] = list.getList().get(j).getPoints();
            containData[3] = list.getList().get(j).getAverage();
            i++;
            tblModel.addRow(containData);
        }
        gui.getTblTable().setModel(tblModel);
    }

    public DefaultTableModel toUpdate() {
        DefaultTableModel tb1Model = (DefaultTableModel) gui.getTblTable().getModel();
        if (gui.getTblTable().getSelectedRowCount() == 1) {
            String fecha = gui.getTxtFecha();
            String puntos = gui.getTxtPuntos();
            String porcentaje = gui.getTxtPorcentaje();

            tb1Model.setValueAt(fecha, gui.getTblTable().getSelectedRow(), 0);
            tb1Model.setValueAt(puntos, gui.getTblTable().getSelectedRow(), 1);
            tb1Model.setValueAt(porcentaje, gui.getTblTable().getSelectedRow(), 2);

            Ui.write("Actualizado exitosamente");

            return tb1Model;

        } else {
            if (gui.getTblTable().getSelectedRowCount() == 0) {
                Ui.write("Error, selecciona una fila");

            } else {
                Ui.write("Por favor selecciona una linea a actualizar");
            }
        }
        return null;
    }

}
