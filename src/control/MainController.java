/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.google.gson.Gson;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import model.Card;
import model.MagicResponse;

/**
 *
 * @author Jennifer
 */
public class MainController {

  public Card getCardsByManaAndColor(String mana, String color) throws IOException {
    Gson gson = new Gson();
    String url =
        "https://api.magicthegathering.io/v1/cards?colors=" + color + "&cmc=" + mana;
    URL obj = new URL(url);

    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.addRequestProperty("User-Agent", "Mozilla/4.76"); 
    con.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

    MagicResponse magicResponse = gson.fromJson(in.readLine(), MagicResponse.class);

    in.close();

    return magicResponse.getCards().stream().findFirst().orElse(null);
  }
  
    public Image getImageCardsByUrl (String urlImage) throws IOException {
        URL imageUrl = new URL(urlImage);
        Image image = ImageIO.read(imageUrl.openStream());

        return image;
    }
}