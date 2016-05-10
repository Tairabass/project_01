package Principal;

import behaviours.Servidor;
import jade.core.Agent;

public class Agente extends Agent{

    protected void setup(){

        Servidor server = new Servidor();
        this.addBehaviour(server);



//        behaviours.RecibirMsg recieve = new behaviours.RecibirMsg();
//        this.addBehaviour(recieve);

    }

}
