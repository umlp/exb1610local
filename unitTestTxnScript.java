import org.junit.Test;
import static org.junit.Assert.* ;

// pour tester le transaction script
public class unitTestTxnScript {

   // init cnx SGBD et base
   private static txnscript txn = txnscript.getTxnscript() ;
   boolean testCnx = txn.check() ;
   
   // init contenu des tables
   boolean testDelete = txn.deleteTableContent ( "villes" ) ;      
   boolean test = txn.loadDml ( "./dml.sql" ) ;

   // tester la méthode list (en fonction du contenu du DML)
   String display = txn.list () ;
   
   @Test
   public void testdBConnection() {
	   assertTrue( testCnx );
   } 

   @Test
   public void testListWithMarrakech() {
	   assertTrue(display.contains("MARRAKECH"));
   }

   @Test
   public void testListIsWithParis() {
	   assertTrue(display.contains("PARIS"));
   }


   @Test
   public void testListMissingWashington() {
	   assertFalse(display.contains("WASHINGTON"));
   }
 

}