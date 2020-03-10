package horario;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Tramo<E,V> {

    private LocalDateTime inicio;

    private LocalDateTime fin;
    
    private Sesion<E,V> sesion;

    public Tramo() {
    }

    public Tramo(LocalDateTime inicio, LocalDateTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    
    public Tramo(LocalDateTime inicio, LocalDateTime fin, Sesion<E,V> sesion) {
        this.inicio=inicio;
        this.fin=fin;
        this.sesion=sesion;
    }

    public boolean hayColision(Tramo<E,V> tramo) throws TramoCollisionException {
        boolean tramoAntesTramo = tramo.getInicio().isBefore(tramo.getFin()) 
                && (tramo.getFin().isBefore(inicio) || tramo.getFin().isEqual(inicio));
        
        boolean tramoDespuesTramo = tramo.getInicio().isBefore(tramo.getFin()) 
                && (tramo.getInicio().isAfter(fin) || tramo.getInicio().isEqual(fin));
        
        if (tramoAntesTramo || tramoDespuesTramo) return false;
        throw new TramoCollisionException(this,tramo);
        
    }
    
    public boolean contieneTramo(Tramo<E,V> tramo){
        boolean dentroTop = this.inicio.isBefore(tramo.getInicio()) || this.inicio.isEqual(tramo.getInicio());
        boolean dentroBottom = this.fin.isAfter(tramo.getFin()) || this.fin.isEqual(tramo.getFin());
                
        return dentroTop && dentroBottom;
    }

    public Duration getDuration() {
        return Duration.between(inicio, fin);
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public Sesion<E, V> getSesion() {
        return sesion;
    }

    public void setSesion(Sesion<E, V> sesion) {
        this.sesion = sesion;
    }
    
    public LocalDateTime getInicioSemana(){
        return this.inicio.toLocalDate().atStartOfDay().with(DayOfWeek.MONDAY);
    }
    
    public LocalDateTime getFinSemana(){
        return this.fin.plusWeeks(1).toLocalDate().atStartOfDay().with(DayOfWeek.MONDAY).minusSeconds(1);
    }
    
    public Tramo getSemana(){
        return new Tramo(getInicioSemana(),getFinSemana());
    }

    @Override
    public String toString() {
        return  inicio + " : " + fin ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.inicio);
        hash = 47 * hash + Objects.hashCode(this.fin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tramo<?, ?> other = (Tramo<?, ?>) obj;
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        
        if (!this.inicio.equals(other.inicio) || !this.fin.equals(other.fin)){
            return false;
        }
        
        return true;
    }
    
    
    
    

}
