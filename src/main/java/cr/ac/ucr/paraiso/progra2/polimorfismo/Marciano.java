/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.polimorfismo;

/**
 *
 * @author Alvaro Mena
 */
public class Marciano extends SpaceObject {

    public Marciano() {
        super();
    }
    

    @Override
    public void pintarse() {
        System.out.println("soy un MARCIANO");
    }
    
    public void visitarMonteOlimpo(){
        System.out.println("Sobreví el tope del OLIMPO");
    }

}
