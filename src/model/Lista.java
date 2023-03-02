package model;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private List<Examen> list;
    private Examen valores;   //accede a los atributos clase Examen

    public Lista() {
        list = new ArrayList<>();

    }

    public boolean add(Examen examen) {
        return list.add(examen);

    }

    public boolean validate(String fecha) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getDate().equalsIgnoreCase(fecha))) {
                return true;
            }

        }
        return false;
    }

    public boolean delete(String fecha) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDate().equalsIgnoreCase(fecha)) {
                list.remove(i);
                return true;

            }
        }

        return false;

    }

    public void update(String nuevaFecha, int nuevosPuntos,
            double nuevoPorcentaje) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setDate(nuevaFecha);
            list.get(i).setPoints(i);
            list.get(i).setAverage(nuevoPorcentaje);

        }

    }

    @Override
    public String toString() {
        return list.toString();
    }

    public List<Examen> getList() {
        return list;
    }

    public void setList(List<Examen> list) {
        this.list = list;
    }

  
    

}
