package horario;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Agenda<E,V> {

    protected HashSet<Agendable<E,V>> agendados;

    public Agenda() {
        agendados=new HashSet<>();
    }

    public Agenda(HashSet<Agendable<E,V>> agendados) {
        this.agendados = agendados;
    }
    
    public boolean hayColisionAgendable(Agendable<E,V> agendable) throws TramoCollisionException {
        for(Agendable<E,V> agendado: agendados){
            for (Sesion<E,V> sesion : agendable.getSesiones()){
                agendado.hayColisionSesion(sesion);
            }
        }
        return false;
    }

    public boolean add(Agendable<E,V> agendable) throws TramoCollisionException {
        hayColisionAgendable(agendable);
        return agendados.add(agendable);
    }

    public boolean hayColisionAgendables(Agendable<E,V> ... agendables) throws TramoCollisionException{
        for(Agendable<E,V> noagendado : agendables){
            hayColisionAgendable(noagendado);
        }
        return false;
    }
    
    public boolean addAll(Agendable<E,V> ... agendables) throws TramoCollisionException {
        boolean retorno = true;
        hayColisionAgendables(agendables);
        for(Agendable<E,V> noagendado : agendables){
            retorno = retorno && agendados.add(noagendado);
        }
        return retorno;
    }
    
    public boolean remove(Agendable agendable) {
        return agendados.remove(agendable);
    }

    public boolean removeAll(Agendable<E,V> ... agendables) {
        
        boolean estanTodos=agendados.containsAll(Arrays.asList(agendables));
        if (estanTodos){
            agendados.removeAll(Arrays.asList(agendables));
        }
        return estanTodos;
    }

    public HashSet<Agendable<E,V>> getAgendados() {
        return agendados;
    }

    public void setAgendados(HashSet<Agendable<E,V>> agendados) {
        this.agendados = agendados;
    }
    
    public boolean isEmpty() {
        return agendados.isEmpty();
    }

    public int size() {
        return agendados.size();
    }

    public void clear() {
        agendados.clear();
    }

    
    
}
