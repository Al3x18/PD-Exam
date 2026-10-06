# PD-Exam — AutoParts

Modulo EJB realizzato come progetto d'esame con Jakarta EE. L'applicazione gestisce un catalogo di ricambi auto, le relative categorie e le quantità disponibili. Include operazioni CRUD, interrogazioni tramite JPA e aggiornamenti asincroni delle vendite tramite JMS.

## Funzionalità

- Ricerca di tutti i ricambi, per identificativo o categoria.
- Inserimento, modifica e cancellazione dei ricambi.
- Ricerca dei prodotti con disponibilità inferiore a 10 unità.
- Aggiornamento asincrono delle quantità vendute tramite un Message-Driven Bean in ascolto sul topic JMS `jms/javaee7/Topic`.
- Pubblicazione di un evento CDI dopo l'aggiornamento di una vendita.
- Inizializzazione di tre record dimostrativi all'avvio del modulo.
- Interceptor personalizzato che conta e registra le invocazioni dei metodi dell'EJB.

## Tecnologie

- Java 17
- Jakarta EE 10: EJB, JPA, CDI, JMS e JAX-WS
- Apache Derby
- NetBeans e Apache Ant
- GlassFish 7

## Struttura principale

- `src/java/ejb/AutoParts.java` — entità JPA e query denominate.
- `src/java/ejb/AutoPartsEJB.java` — EJB stateless con operazioni CRUD e servizio web.
- `src/java/ejb/AutoPartsMDB.java` — ricezione dei messaggi JMS e aggiornamento delle vendite.
- `src/java/ejb/DatabasePopulator.java` — inizializzazione dei dati dimostrativi.
- `src/java/ejb/CounterInterceptor.java` — conteggio e registrazione delle invocazioni.
- `src/conf/persistence.xml` — unità di persistenza JPA.
- `src/conf/glassfish-resources.xml` e `setup/sun-resources.xml` — definizioni delle risorse Derby e JMS.

## Dati dimostrativi e persistenza

`DatabasePopulator` inserisce all'avvio tre ricambi di esempio. In `persistence.xml` la generazione dello schema è impostata su `drop-and-create`: la distribuzione può quindi eliminare e ricreare lo schema. Usa questa configurazione solo con dati di prova e modificala prima di conservare dati persistenti.
