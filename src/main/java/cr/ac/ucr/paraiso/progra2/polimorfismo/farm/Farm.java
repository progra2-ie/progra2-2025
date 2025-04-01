/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.polimorfismo.farm;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Alvaro Mena
 */
public class Farm {
    private Collection<Animal> farmAnimals;

    public Farm() {
        farmAnimals = new LinkedList<>();
    }

    public Collection<Animal> getFarmAnimals() {
        return farmAnimals;
    }

    public void setFarmAnimals(Collection<Animal> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }
    
    public void callAllTheAnimals(){
        for (Animal farmAnimal : farmAnimals) {
            farmAnimal.callTheAnimal();
        }
    }
    public void callAllTheCows(){
        for (Animal farmAnimal : farmAnimals) {
            if (farmAnimal instanceof Cow)
                farmAnimal.callTheAnimal();
        }
    }
    
}
