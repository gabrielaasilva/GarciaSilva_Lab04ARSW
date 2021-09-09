package edu.eci.arsw.blueprints.test.persistence;
import edu.eci.arsw.blueprints.model.*;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jgarc
 */
public class FiltroRedundanciaTest {


    @Test
    public void deberiaFiltrarUnPlanoPorRedundancia() {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Filtro filtro  = new FiltroRedundancia();
        try {
            Point[] pts = new Point[]{new Point(1, 2),new Point(1, 2), new Point(5, 6),new Point(7, 8)};
            Blueprint bp = new Blueprint("john", "thepaint", pts);

            ibpp.saveBlueprint(bp);
            Blueprint blueprint = ibpp.getBlueprint("john","thepaint");
            blueprint = filtro.filtrado ( blueprint );
            assertTrue( blueprint.getPoints().size() == 3 );

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Fallo erroneo");
        }
    }

    @Test
    public void noDeberiaFiltrarUnPlanoPorRedundancia() {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Filtro filtro  = new FiltroRedundancia();
        try {
            Point[] pts = new Point[]{new Point(1, 2),new Point(3, 4), new Point(5, 6),new Point(7, 8)};
            Blueprint bp = new Blueprint("john", "thepaint", pts);

            ibpp.saveBlueprint(bp);
            Blueprint blueprint = ibpp.getBlueprint("john","thepaint");
            blueprint = filtro.filtrado ( blueprint );
            assertTrue( blueprint.getPoints().size() == 4 );




        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Fallo erroneo");
        }
    }
    @Test
    public void DeberiaFiltrarUnPlanoPorRedundanciaTodosIguales() {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Filtro filtro = new FiltroRedundancia();
        try {
            Point[] pts = new Point[]{new Point(1, 2), new Point(1, 2), new Point(1, 2), new Point(1, 2)};
            Blueprint bp = new Blueprint("john", "thepaint", pts);

            ibpp.saveBlueprint(bp);
            Blueprint blueprint = ibpp.getBlueprint("john", "thepaint");
            blueprint = filtro.filtrado(blueprint);
            assertTrue(blueprint.getPoints().size() == 1);


        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Fallo erroneo");
        }
    }
}




