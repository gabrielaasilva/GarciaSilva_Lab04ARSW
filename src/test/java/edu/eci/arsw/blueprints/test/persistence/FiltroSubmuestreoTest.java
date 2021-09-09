/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.*;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author jgarc
 * @author agsilva
 */
public class FiltroSubmuestreoTest {
    public InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
    public Filtro filtro  = new FiltroSubmuestreo();

    @Test
    public void deberiaFiltrarUnPlanoPorSubMuestreoTamañoPar() {
        try {
            Point[] pts = new Point[]{new Point(1, 2),new Point(3, 4), new Point(5, 6),new Point(7, 8)};
            Blueprint bp = new Blueprint("john", "thepaint", pts);

            ibpp.saveBlueprint(bp);
            Blueprint blueprint = ibpp.getBlueprint("john","thepaint");
            blueprint = filtro.filtrado ( blueprint );
            assertTrue( blueprint.getPoints().size() == 2 );

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Fallo erroneo");
        }
    }
    @Test
    public void deberiaFiltrarUnPlanoPorSubMuestreoTamañoInpar() {
        try {
            Point[] pts = new Point[]{new Point(1, 2),new Point(3, 4), new Point(5, 6),new Point(7, 8),new Point(9, 10)};
            Blueprint bp = new Blueprint("john", "thepaint", pts);

            ibpp.saveBlueprint(bp);
            Blueprint blueprint = ibpp.getBlueprint("john","thepaint");
            blueprint = filtro.filtrado ( blueprint );
            //System.out.println( blueprint.getPoints().size());
            assertTrue( blueprint.getPoints().size() == 2 );

        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Fallo erroneo");
        }
    }

}