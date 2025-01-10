/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Alex
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/EsameDS",
        user = "APP", password = "APP",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator implements Serializable {

    @Inject
    private AutoPartsEJB autoPartsEJB;
    private AutoParts a1, a2, a3;

    @PostConstruct
    private void initDB() {
        a1 = new AutoParts(1, "Dischi Freni", Category.Freni, 49.90, 100, 1000);
        a2 = new AutoParts(2, "Sensore T", Category.Motore, 20.50, 9, 5000);
        a3 = new AutoParts(3, "FAP", Category.Filtri, 30F, 1000, 2000);

        autoPartsEJB.createPart(a1);
        autoPartsEJB.createPart(a2);
        autoPartsEJB.createPart(a3);
    }

    /*
    @PreDestroy
    private void clearDB() {
        System.out.println("Cancellazione del DB...");
        autoPartsEJB.deletePart(a1);
        autoPartsEJB.deletePart(a2);
        autoPartsEJB.deletePart(a3);
        System.out.println("DB cancellato.");
    }
*/

}
