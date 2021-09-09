package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service("blueprintsServices")
public class BlueprintsServices {
    @Autowired
    @Qualifier("inMemoryPersistence")
    BlueprintsPersistence bpp = null ;
    
     /*public BlueprintsServices(){
        bpp = new InMemoryBlueprintPersistence();
    }*/
    

    public void addNewBlueprint(Blueprint bp){
        try {
            bpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException e) {
            e.printStackTrace();
        }
    }

    public Set<Blueprint> getAllBlueprints(){
        try {
            return bpp.getAllBlueprints();
        } catch (BlueprintNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author,String name){
        try {
            return bpp.getBlueprint(author,name);
        } catch (BlueprintNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author){
        try {
            return bpp.getBlueprintsByAuthor(author);
        } catch (BlueprintNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteBlueprint(String author , String name ){
        try{
            bpp.deleteBlueprint(author, name );
        }catch(Exception e ){
            e.printStackTrace();

        }
    }
}