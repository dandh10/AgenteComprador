package agents;

import jade.core.Agent;
import behaviours.RequestPerformer;
import gui.InterfazComprador;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class BookBuyerAgent extends Agent {
  private String bookTitle;
  private AID[] sellerAgents;
  private int ticker_timer = 10000;
  private BookBuyerAgent this_agent = this;
  private InterfazComprador gui;
  
  protected void setup() {
    System.out.println("Agente Comprador " + getAID().getName() + " esta listo");
    
    gui = new InterfazComprador(this);
    gui.showGui();
    
    //Argumentos para un agente por medio de una gui
    
      bookTitle = (String) this_agent.getBookTitle();
      //System.out.println("Book: " + bookTitle);
      
      addBehaviour(new TickerBehaviour(this, ticker_timer) {
        protected void onTick() {
          
          System.out.println("Comprando... " + bookTitle);
          
          DFAgentDescription template = new DFAgentDescription();
          ServiceDescription sd = new ServiceDescription();
          sd.setType("book-selling");
          template.addServices(sd);
          
          try {
            DFAgentDescription[] result = DFService.search(myAgent, template);
            System.out.println("Found the following seller agents:");
            sellerAgents = new AID[result.length];
            for(int i = 0; i < result.length; i++) {
              sellerAgents[i] = result[i].getName();
              System.out.println(sellerAgents[i].getName());
            }
            
          }catch(FIPAException fe) {
            fe.printStackTrace();
          }
          
          myAgent.addBehaviour(new RequestPerformer(this_agent));
        }
      });
 
  }
  
  protected void takeDown() {
    System.out.println("Agente Comprador" + getAID().getName() + "Terminando");
  }
  
  public AID[] getSellerAgents() {
    return sellerAgents;
  }
  
  public void setBookTitle(String BookTitle){
      this.bookTitle = BookTitle;
  }
  
  public String getBookTitle() {
    return bookTitle;
  }
  
}
