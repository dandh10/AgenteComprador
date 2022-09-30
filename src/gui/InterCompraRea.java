/*
 * To change this license header, choose License Headers in Project Properties.
 * Nombre:  Jose Daniel Delgado Herrera
 * NC: 18290872
 */
package gui;

import behaviours.RequestPerformer;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 *
 */
public class InterCompraRea extends JFrame{
    
    public InterCompraRea(String bookTitle, String agent, int price){
        JPanel p = new JPanel();
        p.setBackground(Color.GREEN);
        JButton b = new JButton("Ok");
        b.setBackground(Color.yellow);
        p.setLayout(new GridLayout(5, 1));
        p.add(new JLabel("CONFIRMACIÓN DE COMPRA"));
	p.add(new JLabel("Libro: " + bookTitle));
        p.add(new JLabel("Vendido por el : " + agent));
        p.add(new JLabel("Precio de $" + price));
        p.add(b);
        getContentPane().add(p, BorderLayout.CENTER);
        
	b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
            
        }); 
    }
    public void showGui() {
	  pack();
          this.setLocationRelativeTo(null);
          this.setSize(new Dimension(400, 300));
	  super.setVisible(true);
    }
    
}
