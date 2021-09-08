package JunitTest;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.petSmile.conexion.Conexion;


public class ConexionTest {
	
	public ConexionTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public static void setUpClass() {
		
	}
	
	@AfterClass
	public static void tearDownCLass() {
		
	}
	
	@Before
	public void setUp(){
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testConexion() throws SQLException {
		
		boolean conectado = false;
		Connection con = Conexion.getConnection();
		Statement st = con.createStatement();
	    ResultSet rs;
	    rs = st.executeQuery("SELECT id FROM usuario WHERE nombreUsuario='max' AND password='admin'");
		if(rs.next()) {
			System.out.println("id = " +rs.getString("id"));
			System.out.println("Conexion exitosa");
			conectado = true;
		}	    
	    
		assertEquals(conectado, true);	
	}
}
