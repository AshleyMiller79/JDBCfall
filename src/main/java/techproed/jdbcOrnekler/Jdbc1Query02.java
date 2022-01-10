package techproed.jdbcOrnekler;

import java.sql.*;   // Tum JDBC metotlarini eklemek icin 

public class Jdbc1Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	String yol = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";
//		
		Class.forName("com.mysql.cj.jdbc.Driver");
//		
		Connection con = DriverManager.getConnection(yol, "root", "face571622star");
		
		Statement st = con.createStatement();
//		
//	
//		/*=======================================================================
//		 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
//		========================================================================*/ 
		//String selectQuery = "SELECT * FROM bolumler";
		ResultSet tablo1 = st.executeQuery("SELECT * FROM bolumler");
		
		while(tablo1.next()) {
			System.out.println(tablo1.getInt(1) + " " + tablo1.getString(2) + " "+tablo1.getString(3));
		}
		System.out.println("=====================================");
//		
//		/*=======================================================================
//		 ORNEK2: SATIS ve MUHASEBE bolumlerinde calisan personelin isimlerini ve 
// 		 maaslarini, maas ters sirali olarak listeleyiniz
//		========================================================================*/ 
		String q2 = "SELECT personel_isim,maas"
				 + " FROM personel"
				 + " WHERE bolum_id IN(10,30)"
				 + " ORDER BY maas DESC";
		
		ResultSet sonuc = st.executeQuery(q2);
		
		while(sonuc.next()) {
			System.out.println("ISIM:" + sonuc.getString(1) + "\t" + "MAAS:" + sonuc.getInt(2));
		}
		
		System.out.println("=====================================");
//		/*=======================================================================
//		  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
//		  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa 
//		  bile bolum ismi gosterilmelidir.
//		========================================================================*/ 
//	
		String q3 = "select b.bolum_isim, p.personel_isim, p.maas"
			+"	from bolumler b "
			+" left join personel p"
			+"	on p.bolum_id=b.bolum_id"
			+"	ORDER BY b.bolum_isim desc,p.maas ";
		
		ResultSet sonuc1 = st.executeQuery(q3);
		
		while(sonuc1.next()) {
			System.out.println(sonuc1.getString(1) + "|" + sonuc1.getString(2) + "|" + sonuc1.getInt(3));
		}
		System.out.println("=====================================");
//		
//		/*=======================================================================
//		  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
//		========================================================================*/ 
//		
		String q4 = "SELECT b.bolum_isim, p.personel_isim, p.maas"
				 + " FROM personel p"
				 + " left JOIN bolumler b"
				 + " ON b.bolum_id = p.bolum_id"
				 + " ORDER BY p.maas DESC"
				 + " limit 10";
		
		ResultSet sonuc2 = st.executeQuery(q4);
		
		while(sonuc2.next()) {
			System.out.println(sonuc2.getString(1) + " " + sonuc2.getString(2) + " " + sonuc2.getInt(3));
		}
		
		con.close();
		st.close();
		sonuc.close();
		sonuc1.close();
		sonuc2.close();
		tablo1.close();
	}

}
