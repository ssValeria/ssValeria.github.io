package pw;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class oraclejava {
	 private Connection conn  ;
    private Statement stmt  ;
    
   public void conectar(){
       
        String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
        String USER = "planetwars";
        String PASS = "planetwars";
        // Creating Connection
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            if (conn != null) {
                System.out.println("Connected to the Oracle DB!");
                // Crear el Statement después de haber establecido la conexión
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Intentar cerrar el Statement y la conexión en el bloque finally
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   public void insertar(int getMetal, int getDeuterium, int getTechnologyDefense, int getTechnologyAtack, int missileLauncher, int ionCannon, int plasmaCannon, 
		   int ligthHunter, int heavyHunter, int battleShip, int armoredShip) {
	   String update = "INSERT INTO planet_stats(planet_id, name, resource_metal_amount, resource_deuterion_amount,"
               + "technology_defense_level, technology_attack_level, battle_counter, "
               + "missile_launcher_remaining, ion_cannon_remaining, plasma_canon_remaining, "
               + "light_hunter_remaining, heavy_hunter_remaining, battleship_remaining, armored_ship_remaining)"
               + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	   int id = 1;
	   
	   
       try {
		ResultSet rs= stmt.executeQuery("SELECT * FROM Planet_stats");
		while (rs.next()) {
			id = rs.getInt(1)+1;
			
			
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		PreparedStatement ps = conn.prepareStatement(update,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, id );
        ps.setString(2, " ");
        ps.setInt(3, getMetal);
        ps.setInt(4, getDeuterium);
        ps.setInt(5, getTechnologyDefense);
        ps.setInt(6, getTechnologyAtack);
        ps.setInt(7, 0);
        ps.setInt(8, missileLauncher);
        ps.setInt(9, ionCannon);
        ps.setInt(10, plasmaCannon);
        ps.setInt(11, ligthHunter);
        ps.setInt(12, heavyHunter);
        ps.setInt(13, battleShip);
        ps.setInt(14, armoredShip);
        ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
       
   }
}