package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class jaspercontroller implements Initializable{
	public String o="UNKNOWN";
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;
	public jaspercontroller(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice","root", "");
			stat = con.createStatement();
			JasperReport jr= JasperCompileManager.compileReport("F:\\Ict\\JAVA\\jasperpractise\\src\\application\\new.jrxml");
			JasperPrint jp= JasperFillManager.fillReport(jr, null,con);
			JasperViewer.viewReport(jp);
		}catch(Exception ex){
			System.out.println("Error: "+ex);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//	try {
////		JasperReport jr= JasperCompileManager.compileReport("F:\\Ict\\JAVA\\jasperpractise\\src\\application\\2Blank_A4.jrxml");
////		JasperPrint jp= JasperFillManager.fillReport(jr, null,con);
////		JasperViewer.viewReport(jp);
//	} catch (JRException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
	}

}
