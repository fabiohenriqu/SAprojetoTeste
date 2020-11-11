package br.com.projetoDAO.DAO;

import br.com.projetoDAO.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaDAOTest {

    Pessoa p;
    Pessoa p2;

    public PessoaDAOTest() {
        p = new Pessoa("Sandra", "Professora");
        p2 = new Pessoa("Julio", "Pedreiro");
    }

    @BeforeClass
    public static void setUpClass() {

        System.out.println("Antes da classe");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Depois da classe");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of consulta method, of class PessoaDAO.
     */
    @Test
    public void testConsulta() {
        System.out.println("consulta");
        PessoaDAO instance = new PessoaDAO();

        assertTrue(instance.consulta());

    }
    
      @Test
    public void testConsultaID() {
        System.out.println("consulta por ID");
        PessoaDAO instance = new PessoaDAO();

        assertTrue(instance.consultaID());

    }

    @Test
    public void testInserir() {
        System.out.println("Inserir");
        PessoaDAO pd = new PessoaDAO();
        //pd.inserir(p);
        assertTrue(pd.inserir(p));
    }

    @Test
    public void testAtualizar() {
        System.out.println("Atualizar");
        PessoaDAO pde = new PessoaDAO();

        assertTrue(pde.atualizar(p2));

    }
    
    @Test
    public void testDeletar() {
        
        System.out.println("Deletar");
        PessoaDAO pdx = new PessoaDAO();

        assertTrue(pdx.delete());

    }
    
    
    
    

}
