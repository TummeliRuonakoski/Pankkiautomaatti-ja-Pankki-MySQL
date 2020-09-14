package application;

import java.sql.ResultSet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Automaatti extends Application {

	Tietokanta t;
	int vaihto;
	Label naytto;
	int saldo;
	int summa;
	int uusisumma;
	String kortinnumero;
	String salasana1;
	boolean oikea;



	@Override
	public void start(Stage ikkuna) {

		t = new Tietokanta();
		t.yhteydenAvaus();

		BorderPane kehys = new BorderPane();
		kehys.setPadding(new Insets(10, 10, 10, 10));
		Scene aloitus = new Scene(kehys,500,400);
		GridPane kortti = new GridPane();
		vaihto = 1;
		kortti.setVgap(10);
		kortti.setHgap(10);
		kortti.setPadding(new Insets(10, 10, 10, 10));
		kehys.setTop(kortti);
		Label otsikko = new Label("Pankkiautomaatti");
		otsikko.setUnderline(true);
		otsikko.setTextFill(Color.CORAL);
		otsikko.setFont(new Font("Arial", 35));
		Label teksti = new Label("Kortin numero");
		teksti.setFont(new Font("Arial", 20));
		TextField numero = new TextField();
		PasswordField salasanamaski = new PasswordField();
		salasanamaski.setEditable(false);
		salasanamaski.setMouseTransparent(true);
		salasanamaski.setFocusTraversable(false);
		Label ilmoitus = new Label(" ");
		kortti.add(otsikko, 0, 0,2,1);
		kortti.add(teksti, 0, 1);
		kortti.add(numero, 1, 1);
		kortti.add(salasanamaski, 0, 2,2,1);
		kortti.add(ilmoitus, 0, 3);

		GridPane salasana = new GridPane();
		kehys.setCenter(salasana);
		salasana.setVgap(10);
		salasana.setHgap(10);
		salasana.setPadding(new Insets(10, 10, 10, 10));


		Button yksi = new Button("1");
		yksi.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "1");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "1");
			}
		});
		Button kaksi = new Button("2");
		kaksi.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "2");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "2");
			}});
		Button kolme = new Button("3");
		kolme.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "3");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "3");
			}});
		Button nelja = new Button("4");
		nelja.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "4");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "4");
			}});
		Button viisi = new Button("5");
		viisi.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "5");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "5");
			}});
		Button kuusi = new Button("6");
		kuusi.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "6");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "6");
			}});
		Button seitseman = new Button("7");
		seitseman.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "7");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "7");
			}});
		Button kahdeksan = new Button("8");
		kahdeksan.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "8");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "8");
			}});
		Button yhdeksan = new Button("9");
		yhdeksan.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "9");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "9");
			}});

		Button nolla = new Button("0");
		nolla.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText() + "0");
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText() + "0");
			}});
		Button stop = new Button("stop");
		stop.setOnAction((event) -> {
			System.exit(1);
		});
		Button poisto = new Button("⌫");
		poisto.setOnAction((event) -> {
			if(vaihto == 1) {
				salasanamaski.setText(salasanamaski.getText().substring(0, salasanamaski.getText().length() -1));
			}
			if(vaihto == 2) {
				naytto.setText(naytto.getText().substring(0, naytto.getText().length() -1));

			}});

		Button ok = new Button("ok");



		salasana.add(yksi, 0, 1);
		salasana.add(kaksi, 1, 1);
		salasana.add(kolme, 2, 1);
		salasana.add(stop, 3, 1);
		salasana.add(nelja, 0, 2);
		salasana.add(viisi, 1, 2);
		salasana.add(kuusi, 2, 2);
		salasana.add(poisto, 3, 2);
		salasana.add(seitseman, 0, 3);
		salasana.add(kahdeksan, 1, 3);
		salasana.add(yhdeksan, 2, 3);
		salasana.add(ok, 3, 3);
		salasana.add(nolla, 0, 4);

		BorderPane tapahtuma = new BorderPane();
		tapahtuma.setPadding(new Insets(10, 10, 10, 10));
		ok.setOnAction((event) -> {
			salasana1 = salasanamaski.getText();
			kortinnumero = numero.getText();
			oikea = t.tarkistaKayttaja(kortinnumero, salasana1);
			if(!oikea) {
				ilmoitus.setText("Tarkista tunnus tai salasana");
			}else {
				System.out.println("tunnus oikea");
				kehys.setTop(tapahtuma);
				vaihto = 2;
			}
		});

		HBox valinta = new HBox(10);
		valinta.setPadding(new Insets(0, 0, 15, 0));
		tapahtuma.setTop(valinta);
		Button vb1 = new Button("otto");
		Button vb2 = new Button("pano");
		Button vb3 = new Button("saldo");
		valinta.getChildren().addAll(vb1,vb2,vb3);
		VBox n1 = new VBox(5);
		Label t1 = new Label("paina haluamasi summa, jonka jälkeen valitse toiminto" + "\n" + "tai valitse suoraan saldo");
		t1.setFont(new Font("Arial",16));
		naytto = new Label();
		Label koriste = new Label("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
		koriste.setStyle("-fx-color:black");
		n1.getChildren().addAll(t1,naytto, koriste);
		tapahtuma.setCenter(n1);
		vb1.setOnAction((event) -> {
			summa = Integer.parseInt(naytto.getText());
			ResultSet res = t.haeSaldo(kortinnumero);
			int saldo = 0;

			try {
				if (res.next()) {
					saldo = res.getInt("saldo");
					uusisumma = saldo - summa;
					System.out.println(saldo + " - " + summa);
					if(uusisumma >=0) {
						t.saldonMuuttaminen(kortinnumero, uusisumma);
						System.out.println(uusisumma);
					}else {
						naytto.setText("tillä ei ole tarpeeksi rahaa - tapahtumaa ei voitu suorittaa");
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		});


		vb2.setOnAction((event) -> {
			summa = Integer.parseInt(naytto.getText());
			ResultSet res = t.haeSaldo(kortinnumero);
			int saldo = 0;
			try{
				if (res.next()) {
					saldo = res.getInt("saldo");
					uusisumma = saldo + summa;
					System.out.println(saldo + " + " + summa);
					t.saldonMuuttaminen(kortinnumero, uusisumma);
					System.out.println(uusisumma);
				}
			}catch (Exception e) {
				System.out.println(e);
			}

		});
		vb3.setOnAction((event) -> {
			ResultSet res = t.haeSaldo(kortinnumero);
			int saldo = 0;
			try{
				if (res.next()) {
					saldo = res.getInt("saldo");
					naytto.setText(saldo + "€");
					System.out.println(saldo);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		});


		ikkuna.setScene(aloitus);
		ikkuna.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
