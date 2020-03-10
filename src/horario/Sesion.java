package horario;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Sesion<E,V>{

    protected Tramo tramo;

    protected Agendable<E,V> agendable;

    public Sesion() {
    }

    public Sesion(Agendable<E, V> agendable) {
        this.agendable = agendable;
    }
    
    public Sesion(Tramo tramo, Agendable<E,V> agendable) {
        this.tramo = tramo;
        this.agendable = agendable;
    }

    public Tramo getTramo() {
        return tramo;
    }

    public Agendable<E,V> getAgendable() {
        return agendable;
    }

    public Duration getDuration() {
        return tramo.getDuration();
    }

    public LocalDateTime getInicio() {
        return tramo.getInicio();
    }

    public LocalDateTime getFin() {
        return tramo.getFin();
    }

    public void setTramo(Tramo tramo) {
        this.tramo = tramo;
    }

    public void setAgendable(Agendable<E,V> agendable) {
        this.agendable = agendable;
    }
    
    
}
