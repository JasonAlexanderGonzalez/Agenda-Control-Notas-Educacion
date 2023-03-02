package controller;

import model.Examen;
import model.Lista;
import view.Ui;

public class Controller {

    private Lista list;

    public Controller() {
        this.list = new Lista();
        control();
    }

    public void control() {
        int op = 0;
        while (true) {
            op = Ui.readNum("1. Ingresar \n 2. Eliminar \n"
                    + "3. Mostrar Examenes % \n 4. Salir");
            switch (op) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    list();
                    break;

                case 4:
                    System.exit(0);

                default:
                    Ui.write("Opción incorrecta");
            }
        }
    }

    public void delete() {
        String num = Ui.read("Ingrese el nombre del Examen a eliminar");
        if (list.delete(num)) {
            Ui.write("Examen eliminado");
        } else {
            Ui.write("No se encontro el examen");
        }
    }

    public void list() {
        Ui.write(list.toString());

    }

    public void add() {

        String fecha = "";
        do {
            fecha = Ui.read("Ingrese la fecha del examen");

        } while (list.validate(fecha));

        int nota = Ui.readNum("Ingrese la nota del examen");

        double porcentaje = Ui.readNum2("Ingrese el porcentaje");
        if (list.add(new Examen(fecha, nota, porcentaje))) {

            Ui.write("Examen agregado");
        } else {
            Ui.write("Error al agregar nota");
        }

    }

}
