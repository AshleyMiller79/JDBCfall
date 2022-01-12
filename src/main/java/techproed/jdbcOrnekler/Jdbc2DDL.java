package techproed.jdbcOrnekler;

import java.sql.*;   // Tum JDBC metotlarini eklemek icin 

public class Jdbc2DDL {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String yol = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(yol, "root", "face571622star");
		
		Statement st = con.createStatement();
		
		/*
	 	A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
	 	   dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
	 	    1) execute() metodu 
	 	    2) excuteUpdate() metodu.  
	 	    
	 	B) - execute() metodu hertur SQL ifadesiyle kullanibilen genel bir komuttur. 
	 	   - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken, 
	 	     DML islemlerinde true deger dondurur. 
	 	   - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
	 	     durumlarda tercih edilmektedir.  
	 	     
	 	C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
	 	   - bu islemlerde islemden etkilenen satir sayisini dondurur.
	 	   - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	 */
		/*=======================================================================
		  ORNEK1:isciler adinda bir tablo olusturunuz id int, 
		  birim VARCHAR(10), maas int
//		========================================================================*/ 
//		String createQuery = "CREATE TABLE isciler"
//						 + " (id int primary key,"
//				         + " birim VARCHAR(10),"
//				         + " maas int)";
//		
//////		// 1.YONTEM  - execute() metodu ile
//		boolean s1 = st.execute(createQuery);   // false deger dondurur. (DDL)
//	System.out.println("isciler tablosu olusturuldu " + s1);
//		
//		// execute() metodu DDL komutlarinda hep false deger dondurdugu icin 
//		// donus degerine bakmak gerekli degildir. Zaten komutun calismasi ile 
//		// ilgili bir sorun var ise SQL EXception olusacaktir.
//		
//		st.execute(createQuery); 
//	System.out.println("isciler tablosu olusturuldu..");
//////		
//		// 2.YONTEM - executeUpdate() metodu ile
//		int s2 = st.executeUpdate(createQuery);  // DDL islemlerinde 0 degerini dondurur.
//		System.out.println("isciler tablosu olusturuldu.." + s2);
////		
//		// executeUpdate() metodu da DDL komutlarinda hep 0 degeri dondurur.
//		// bu sebeple donus degerine bakmak gerekli degildir.
//		st.executeUpdate(createQuery);  
//		System.out.println("isciler tablosu olusturuldu..");
////		
//		/*======================================================================
//		  ORNEK2:isciler tablosunu siliniz 		
////		========================================================================*/
//		String dropQuery1 = "drop table isciler";
//		st.execute(dropQuery1);
////	
//	
//	System.out.println("isciler tablosu silindi..");
//////		
////		/*=======================================================================
////		  ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar(20)} ekleyiniz.   
////////		========================================================================*/ 
//		String alterQuery1 = "ALTER TABLE isciler ADD isim VARCHAR(20)";
//		st.executeUpdate(alterQuery1);
//		System.out.println("isciler tablosuna isim sutunu eklendi..");
//		
////		/*=======================================================================
////		  ORNEK4:isciler tablosuna soyisim VARCHAR(20) ve sehir VARCHAR(10)) 
////		  adinda 2 yeni sutun ekleyiniz.  
////		========================================================================*/ 
//		String alterQuery2 = "ALTER TABLE isciler"
//				          + " ADD (soyisim VARCHAR(20), sehir VARCHAR(20))";
//		st.execute(alterQuery2);
//		System.out.println("isciler tablosuna soyisim ve sehir sutunu eklendi..");
//////		
//		/*=======================================================================
//		  ORNEK5:isciler tablosundaki soyisim sutunu siliniz.
////		========================================================================*/ 
//		String alterQuery3 = "ALTER TABLE isciler DROP COLUMN birim";
//		st.execute(alterQuery3);
//////		
//		System.out.println("isciler tablosundan birim sutunu silindi..");
	
//		/*=======================================================================
//		  ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz.  
////		========================================================================*/
//		String alterQuery4 = "ALTER TABLE isciler RENAME TO calisanlar5";
//		st.execute(alterQuery4);
//		System.out.println("isciler tablosunun adi calisanlar olarak degismistir..");
////		
////		/*=======================================================================
////		  ORNEK7:calisanlar tablosunu siliniz.  
////		========================================================================*/
//		String dropQuery2 = "DROP TABLE calisanlar5 ";
//		st.execute(dropQuery2);
//	
//		System.out.println("calisanlar tablosu silindi..");
////		
		st.close();
		con.close();
	}
}
