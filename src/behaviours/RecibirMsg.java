package behaviours;

import Principal.Mapa;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class RecibirMsg extends CyclicBehaviour{

    ACLMessage msg;
    Mapa mapa = new Mapa();

    public RecibirMsg(ACLMessage msg){ this.msg = msg; }

    @Override
    public void action(){

        if(this.msg != null){
            mapa.actualizarMapa(msg.getContent());
//          System.out.println(envio.getSender().getLocalName() + ": " + envio.getContent());
            EnviarMsg mensaje = new EnviarMsg(this.msg.getSender().getLocalName(), "2", ACLMessage.PROPOSE, false);
            myAgent.addBehaviour(mensaje);
        } else
            block();

        this.msg = myAgent.receive();

    }

}
