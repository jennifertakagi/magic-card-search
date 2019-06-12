/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MainController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Card;

/**
 *
 * @author Jennifer
 */
public class MainFrame extends JFrame implements ActionListener {
  private JTextField manaField;
  private JTextField colorField;
  private JFrame frame;
  private final MainController magicController = new MainController();

  public void openFrame() {
    frame = new JFrame();
    GridBagConstraints c = new GridBagConstraints();
    frame.setLayout(new GridBagLayout());

    JLabel manaLabel = new JLabel();
    manaLabel.setText("Enter mana cost");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    frame.add(manaLabel, c);

    manaField = new JTextField(10);
    manaField.setEditable(Boolean.TRUE);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 0;
    frame.add(manaField, c);

    JLabel colorLabel = new JLabel();
    colorLabel.setText("Enter color");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    frame.add(colorLabel, c);

    colorField = new JTextField(10);
    colorField.setEditable(Boolean.TRUE);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 1;
    frame.add(colorField, c);

    JButton searchButton = new JButton();
    searchButton.setText("Search");
    searchButton.addActionListener(this);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 2;
    frame.add(searchButton, c);
    
    frame.setTitle("Magic Card Search");
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent ae) {
    String mana = manaField.getText();
    String color = colorField.getText();

    try {
      Card card = magicController.getCardsByManaAndColor(mana, color);
      System.out.println("Card name: " + (Objects.nonNull(card) ? card.getUrlImage() : "Card not found"));
      JLabel label = new JLabel(new ImageIcon(card.getUrlImage()));
      frame.add(label);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}