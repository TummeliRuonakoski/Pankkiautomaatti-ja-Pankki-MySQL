package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tietokanta {

	Connection con;
	String hetu;
	int oikea;
	public Connection yhteydenAvaus() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pankkiautomaatti?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "tunnus", "salasana");
			return con;
		} catch (Exception e) {

			System.out.println(e);
		}

		return null;
	}



	public String luoAsiakas(String nimi, String hetu, String osoite, int suuntanumero, String kaupunki){
		try {
			ResultSet haku = etsiAsiakas(hetu);
			if(haku.next()) {
				return "Asiakas on jo luotu";
			}else {
				PreparedStatement lauseke = con.prepareStatement("Insert into Asiakkaat(nimi,hetu,osoite,suuntanumero,kaupunki) values (?,?,?,?,?)");
				lauseke.setString(1, nimi);
				lauseke.setString(2, hetu);
				lauseke.setString(3, osoite);
				lauseke.setInt(4, suuntanumero);
				lauseke.setString(5, kaupunki);
				lauseke.executeUpdate();
				return "Uusi asiakas on luotu";
			}
		}

		catch(Exception e) {
			System.out.print(e);

		}
		return null;
	}

	public String luoTili(String hetu, String tilinumero, String kortinnumero, int saldo, String salasana) {
		try {
			ResultSet haku = etsiAsiakas(hetu);
			if(haku.next()) {
				PreparedStatement lauseke = con.prepareStatement("Insert into Tilit(hetu,tilinumero,kortinnumero,saldo,salasana) values (?,?,?,?,?)");

				lauseke.setString(1, hetu);
				lauseke.setString(2, tilinumero);
				lauseke.setString(3, kortinnumero);
				lauseke.setInt(4, saldo);
				lauseke.setString(5, salasana);
				lauseke.executeUpdate();
				return "Asiakkaan tili on luotu";
			}else {
				return "luo ensin asiakas";
			}}

		catch(Exception e) {
			System.out.print(e);
		}

		return null;
	}

	public ResultSet etsiAsiakas(String hetu) {

		try {
			PreparedStatement lauseke = con.prepareStatement("Select * from Asiakkaat where hetu = ?");
			lauseke.setString(1, hetu);
			ResultSet haku = lauseke.executeQuery();
			return haku;
		}

		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}
	public ResultSet haeSaldo(String kortinnumero) {
		try {

			PreparedStatement lauseke = con.prepareStatement("Select saldo from Tilit where kortinnumero = ?");
			lauseke.setString(1, kortinnumero);
			ResultSet haku = lauseke.executeQuery();
			return haku;
		}

		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}


	public ResultSet tarkistatilinumero(String tilinumero) {


		try {
			PreparedStatement lauseke = con.prepareStatement("Select * from Tilit where tilinumero = ?");
			lauseke.setString(1, tilinumero);
			ResultSet haku = lauseke.executeQuery();
			return haku;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;

		}

	}

	public ResultSet tarkistakortinnumero(String kortinnumero) {


		try {
			PreparedStatement lauseke = con.prepareStatement("Select * from Tilit where kortinnumero = ?");
			lauseke.setString(1, kortinnumero);
			ResultSet haku = lauseke.executeQuery();
			return haku;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}

	public void saldonMuuttaminen(String kortinnumero, int uusisaldo) {

		try {
			PreparedStatement lauseke = con.prepareStatement("Update Tilit set saldo = ? where kortinnumero = ?");
			lauseke.setInt(1, uusisaldo);
			lauseke.setString(2, kortinnumero);
			lauseke.executeUpdate();
		}
		catch(Exception e){ 
			System.out.println(e);

		}

	}
	public boolean tarkistaKayttaja(String kortinnumero, String salasana) {

		try {
			PreparedStatement lauseke = con.prepareStatement("Select * from Tilit where kortinnumero = ? and salasana = ?");
			lauseke.setString(1,kortinnumero);
			lauseke.setString(2, salasana);
			ResultSet haku = lauseke.executeQuery();

			if(haku.next()) {
				return true;
			}
		}
		catch(Exception e){ 
			System.out.println(e);
		} 
		return false;
	}

}



