package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		

		
		// 1) ilgili driver ı yüklemeliyiz. tv nin fişini tak, mesela başka alet çalışmasın, ne çalışacağını bilsin
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//2) bağlantı oluşturmalıyız   uydu şifrelerini girmeliyiz
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "face571622star");
		
		//3) SQL komutları için bir Statement nesnesi oluştur her kanal için kumanda da yer ayarlamak
	       Statement st=      con.createStatement();
	       
	   //SQL ifadeleri yazabilir ve çalıştırabiliriz kumanda da 1 e basarım trt1 gelir    
	       
	    ResultSet veri=   st.executeQuery("SELECT isim, maas FROM personel WHERE id=123456789");
	       
	       
	   // 5) sonuçları aldık ve işledik
	       
	       while(veri.next()) {
	    	   System.out.println(veri.getString("isim")  + veri.getInt("maas")  );
	    	   
	    	   System.out.println("Personel Adi:"+ veri.getString(1)+"Maas:"+ veri.getInt(2) );
	    	   
	       }
	       
	    //6) oluşturulan nesneleri bellekten kaldıralım
	       
	       con.close();
	       st.close();
	       veri.close();
	       
	       
	       
	       
	       
		
	}

}
