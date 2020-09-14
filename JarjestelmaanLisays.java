package application;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JarjestelmaanLisays extends Application{

	int numeroOsa;
	String tnumero = "";
	String tilinumero1;
	String kortinnumero1 = "";
	String salasana1 = "";
	String nimi;
	String hetu;
	String osoite;
	int suuntanumero;
	String kaupunki;
	String tilinumero;
	String kortinnumero;
	int saldo;
	String salasana;

	Tietokanta t;

	public String tilinumeronarpominen() {
		Random r = new Random();

		for(int i = 0 ; i < 14 ; i++) {
			numeroOsa = r.nextInt(10);
			tnumero += numeroOsa;
		}
		return tnumero;

	}

	public String kortinnumeronarpominen() {
		Random r2 = new Random();

		for(int i = 0 ; i < 16 ; i++) {
			numeroOsa = r2.nextInt(10);
			kortinnumero1 += numeroOsa;
		}
		return kortinnumero1;

	}
	public String salasananarpominen() {
		Random r3 = new Random();

		for(int i = 0 ; i < 4 ; i++) {
			numeroOsa = r3.nextInt(10);
			salasana1 += numeroOsa;
		}
		return salasana1;
	}

	@Override
	public void start(Stage ikkuna) throws Exception {

		t = new Tietokanta();
		t.yhteydenAvaus();

		BorderPane kehys = new BorderPane();
		kehys.setPadding(new Insets(10, 10, 10, 10));


		HBox otsikko = new HBox();
		Label o1 = new Label("Uuden asiakkaan luominen");
		o1.setFont(new Font("Arial", 30));
		otsikko.getChildren().add(o1);
		kehys.setTop(otsikko);

		GridPane alue = new GridPane();
		kehys.setCenter(alue);
		alue.setVgap(10);
		alue.setHgap(10);
		alue.setPadding(new Insets(10, 10, 10, 10));

		Label l1 = new Label("asiakas:");
		TextField t1 = new TextField();
		t1.setText("etunimi sukunimi");
		Label l2 = new Label("hetu: ");
		TextField t2 = new TextField();
		t2.setText("xxxxxxyyyyy");
		Label l3 = new Label("osoite:");
		TextField t3 = new TextField();
		t3.setText("kadunnimi numero");
		TextField t4 = new TextField();
		t4.setText("suuntanumero");
		TextField t5 = new TextField();
		t5.setText("kaupunki");
		Button b1 = new Button("tilinumero");
		Label l5 = new Label();

		b1.setOnAction((event) -> {
			tilinumeronarpominen();
			tilinumero1 = ("FI22" + tnumero);
			if(tilinumero1.equals(t.tarkistatilinumero(tilinumero))){
				l5.setText("Tilinumero on varattu, arvo asiakkaalle uusi tilinumero.");
			}else {
				l5.setText("asiakkaan tilinumero: " + tilinumero1);
			}
		});

		Button b2 = new Button("kortin numero");
		Label l6 = new Label();
		b2.setOnAction((event) -> {
			kortinnumeronarpominen();
			if(kortinnumero1.equals(t.tarkistakortinnumero(kortinnumero))){
				l6.setText("Kortin numero on varattu, arvo uusi numero kortille.");
			}else {
				l6.setText("asiakkaan kortin numero: " + kortinnumero1);
			}
		});

		Label l7 = new Label("tilin saldo: ");
		TextField t6 = new TextField();
		Label l8 = new Label("euroa");
		Label l9 = new Label("");
		Button b3 = new Button("salasana");
		b3.setOnAction((event) -> {
			salasananarpominen();
			l9.setText("asiakkaan kortin salasana: " + salasana1);
		});

		Button b4 = new Button("tallenna uusi asiakas");
		b4.setUnderline(true);
		alue.setMargin(b4, new Insets(0, 0, 0, - 10));
		b4.setStyle("-fx-background-color: f4f4f4");
		b4.setFont(new Font("Arial", 16));
		b4.setOnAction((event)->{
			nimi = t1.getText();
			hetu = t2.getText();
			osoite = t3.getText();
			suuntanumero = Integer.parseInt(t4.getText());
			kaupunki = t5.getText();
			tilinumero = tilinumero1;
			kortinnumero = kortinnumero1;
			saldo = Integer.parseInt(t6.getText());
			salasana = salasana1;
			String asiakas = t.luoAsiakas(nimi, hetu, osoite, suuntanumero, kaupunki);
			String tilitiedot = t.luoTili(hetu , tilinumero, kortinnumero, saldo, salasana);
			System.out.println("Asiakas luotu. Asiakas: " + asiakas + "Tilitiedot: " + tilitiedot);
		});

		alue.add(l1, 0, 0);
		alue.add(t1, 1, 0);
		alue.add(l2, 0, 1);
		alue.add(t2, 1, 1);
		alue.add(l3, 0, 2);
		alue.add(t3, 1, 2);
		alue.add(t4, 2, 2);
		alue.add(t5, 3, 2);
		alue.add(b1, 0, 3);
		alue.add(l5, 1, 3, 2, 1);
		alue.add(b2, 0, 4);
		alue.add(l6, 1, 4, 2, 1);
		alue.add(l7, 0, 5);
		alue.add(t6, 1, 5);
		alue.add(l8, 2, 5);
		alue.add(b3, 0, 6);
		alue.add(l9, 1, 6, 2, 1);
		alue.add(b4, 0, 7, 2, 1);

		Scene kulissi = new Scene(kehys,600,400);
		ikkuna.setScene(kulissi);
		ikkuna.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
