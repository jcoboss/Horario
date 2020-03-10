/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario;

/**
 *
 * @author Josue
 */
public class TramoCollisionException extends Exception{

    private Tramo tramoAnterior;
    private Tramo tramoNuevo;
    
    public TramoCollisionException() {
    }

    public TramoCollisionException(Tramo tramoAnterior, Tramo tramoNuevo) {
        this.tramoAnterior = tramoAnterior;
        this.tramoNuevo = tramoNuevo;
    }

    public Tramo getTramoAnterior() {
        return tramoAnterior;
    }

    public Tramo getTramoNuevo() {
        return tramoNuevo;
    }
    
    
}
