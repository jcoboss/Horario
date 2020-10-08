/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import horario.Tramo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Josue
 */
public class TramoTest {
    
    public static void main(String [] args){
        
        DateTimeFormatter dd = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //'2011-12-03T10:15:30'.
        Tramo tramoA = new Tramo(LocalDateTime.parse("2019-12-11T12:30:00", dd),LocalDateTime.parse("2019-12-11T13:30:00", dd));
        Tramo tramoB = new Tramo(LocalDateTime.parse("2019-12-11T15:00:00", dd),LocalDateTime.parse("2019-12-11T17:00:00", dd));
        
        for(int i = 0; i<10 ; i++ ){
            System.out.println(tramoA.getInicio().format(dd)+"  -  "+tramoA.getFin().format(dd));
            System.out.println(tramoB.getInicio().format(dd)+"  -  "+tramoB.getFin().format(dd));
            try{
                System.out.println("Colisionan : " + tramoA.hayColision(tramoB));
            }catch(Exception e){
                System.out.println("Colisionan : true");
            }
            tramoA.setInicio(tramoA.getInicio().plusMinutes(30));
            tramoA.setFin(tramoA.getFin().plusMinutes(30));
        }
        
    }
    
}
