
package br.com.kalebe;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
		ProdutoServiceTest.class, ProdutoDAOTest.class,
		VendaDAOTest.class })
public class AllTests {

}