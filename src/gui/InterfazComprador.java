 /* Nombre:  Jose Daniel Delgado Herrera
  NC: 18290872
*/
package gui;

import agents.BookBuyerAgent;
import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import agents.BookSellerAgent;
import java.awt.Color;

public class InterfazComprador extends JFrame {
	private BookBuyerAgent myAgent;
        
	private JTextField titleField;
        
        public InterfazComprador(BookBuyerAgent a){
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
                p.setBackground(Color.GREEN);
                p.setSize(50, 50);
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Titulo del Libro:"));
		titleField = new JTextField(15);
		p.add(titleField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Añadir");
                addButton.setBackground(Color.yellow);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String title = titleField.getText().trim();	
					myAgent.setBookTitle(title);
                                        System.out.println("Libro que desea comprar: " + title);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(InterfazComprador.this, "Invalid values","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
		    //myAgent.doDelete();
                    myAgent.doSuspend();
                    myAgent.doActivate();
		  }
		});
		
		setResizable(false);
	}
	
	public void showGui() {
	  pack();
	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  int centerX = (int)screenSize.getWidth() / 2;
	  int centerY = (int)screenSize.getHeight() / 2;
	  
	  setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
	  super.setVisible(true);
	}
}
