/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author luisj
 */
public class parseDate {
    
    public parseDate(){}
    
    public java.util.Date StringToDate(String fecha){
        
        java.util.Date fechaFinal = new java.util.Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaDate = null;
        
        try{
         fechaFinal = formato.parse(fecha);
        }catch(ParseException ex){
            ex.getMessage();
        }
        
        return fechaFinal;
    }
    
}
