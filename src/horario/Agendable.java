package horario;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Agendable<E,V> {

    protected E evento;

    protected V dictador;

    protected LinkedList<Sesion<E,V>> sesiones;

    public Agendable() {
        sesiones = new LinkedList<>();
    }

    public Agendable(E evento, V dictador) {
        sesiones = new LinkedList<>();
        this.evento = evento;
        this.dictador = dictador;
    }

    
    public boolean hayColisionSesion(Sesion<E,V> sesion) throws TramoCollisionException{
        for(Sesion<E,V> itSesion : sesiones){
            itSesion.getTramo().hayColision(sesion.getTramo());
        }
        return false;
    }

    public void addSesion(Sesion<E,V> sesion) throws TramoCollisionException{
        hayColisionSesion(sesion);
        sesiones.add(sesion);
    }
    
    public boolean hayColisionSesiones(Sesion<E,V> ... sesiones) throws TramoCollisionException{
        for (Sesion<E,V> sesion : sesiones){
            hayColisionSesion(sesion);
        }
        return false;
    }
    
    public void addSesiones(Sesion<E,V> ... sesiones) throws TramoCollisionException{
        hayColisionSesiones(sesiones);
        Collections.addAll(this.sesiones, sesiones);
    }
    
    public boolean removeSesion(Sesion sesion) {
        return sesiones.remove(sesion);
    }

    public E getEvento() {
        return evento;
    }

    public void setEvento(E evento) {
        this.evento = evento;
    }

    public V getDictador() {
        return dictador;
    }

    public void setDictador(V dictador) {
        this.dictador = dictador;
    }

    public LinkedList<Sesion<E,V>> getSesiones() {
        return sesiones;
    }

    public void setSesiones(LinkedList<Sesion<E,V>> sesiones) {
        this.sesiones = sesiones;
    }

    
    
}
