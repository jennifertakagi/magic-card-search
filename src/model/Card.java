/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jennifer
 */
import java.util.List;

public class Card {
  private String name;
  private List<String> colors;
  private String type;
  private String imageUrl;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getColors() {
    return colors;
  }

  public void setColors(List<String> colors) {
    this.colors = colors;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  
    public String getUrlImage() {
    return imageUrl;
  }

  public void setUrlImage(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}

