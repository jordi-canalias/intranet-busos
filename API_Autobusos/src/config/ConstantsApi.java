package config;

public class ConstantsApi {
	public static final String CONNECTION = "jdbc:mysql://localhost:3306/autobusos?serverTimezone=UTC";
	public static final String USER_CONNECTION = "root"; 
	public static final String PASS_CONNECTION = "Patata"; 
	
	
	
	//Secret key para encriptar y desencriptar
	
	public static final String SECRETKEY = "Java>Python";
	
	//Queries de Barrio
	public static final String REINICIAR_BARRIO_INQUILINOS = "REMOVE * FROM daw2tp2.inquilino WHERE casa = ?";
	public static final String REINICIAR_BARRIO_CASAS = "REMOVE * FROM daw2tp2.casa WHERE barrio = ?";
	public static final String GET_BARRIO = "SELECT * FROM daw2tp2.barrio WHERE name = ?";
	
	//Queries de CASA
	public static final String INSERT_CASA = "INSERT INTO daw2tp2.casa (id, barrio) VALUES (?,?)";
	public static final String GET_CASAS = "SELECT * FROM daw2tp2.casa WHERE barrio = ?";
	public static final String GET_CASA_BY_ID = "SELECT * FROM daw2tp2.casa WHERE id = ?";
	public static final String REMOVE_CASA = "DELETE FROM daw2tp2.casa WHERE id = ?";
	
	//Queries de INQUILINO
	public static final String INSERT_INQUILINO = "INSERT INTO daw2tp2.inquilino (id, casa) VALUES (?,?)";	
	public static final String GET_INQUILINOS = "SELECT * FROM daw2tp2.inquilino WHERE casa = ?";
	public static final String GET_INQUILINO_BY_ID = "SELECT * FROM daw2tp2.inquilino WHERE id = ?";	
	public static final String REMOVE_INQUILINO = "DELETE FROM daw2tp2.inquilino WHERE id = ?";
	
}
