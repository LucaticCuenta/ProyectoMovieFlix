package datos;

import java.sql.*;

public class Conexion {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement st = null;
		ResultSet rs=null;
		
		try{
			String driverClassName = "com.mysql.jdbc.Driver";
			String driverUrl= "jdbc:mysql://grupoa/prueba";
			String user = "root";
			String password = "aaaa";
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverUrl,user,password);
			st = con.createStatement();
			String query = "SELECT * from caztegoria;";
			rs = st.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();
			int countCol = rsm.getColumnCount();
			
			System.out.println(" ");
			while(rs.next()){
				
				for(int i=1;i<countCol;i++){
					//System.out.println(" ");
					System.out.print(rs.getString(i));
					if(i<countCol){System.out.println(" ");}
				}
				System.out.println();
				//String nombre = rs.getString(2);
				//Date fecha = rs.getDate("hiredate");
				//System.out.println("Nombre "+nombre+" Fecha "+fecha);
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("No se encuentra el driver");
		}
		catch(SQLException e){
			System.out.println("Excepcion SQL "+e.getMessage());
			System.out.println("Estado SQL "+e.getSQLState());
			System.out.println("Codigo del Error "+e.getErrorCode());
		}
	}

}