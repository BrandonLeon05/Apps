package mx.edu.utng.firebaseapp;

public class Clase {
    //Definir las propiedades de la clase
    String claseid, carrera, materia, tema;


    public Clase(String claseid, String carrera, String materia, String tema) {
        this.claseid = claseid;
        this.carrera = carrera;
        this.materia = materia;
        this.tema = tema;
    }

    public String getClaseid() {
        return claseid;
    }

    public void setClaseid(String claseid) {
        this.claseid = claseid;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
