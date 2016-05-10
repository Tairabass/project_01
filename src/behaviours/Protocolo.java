package behaviours;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.proto.SimpleAchieveREInitiator;

public class Protocolo extends SimpleAchieveREInitiator{

    public Protocolo(Agent a, ACLMessage msg) {
        super(a, msg);
    }

    public void handleAgree(ACLMessage msg) {}

    public void handleRefuse(ACLMessage msg) { }

    public void handleInform(ACLMessage msg) {

        System.out.println(msg.getContent());

        myAgent.addBehaviour(new RecibirMsg(msg));

    }

    public void handleNotUnderstood(ACLMessage msg) { }

    public void handleOutOfSequence(ACLMessage msg) { }

}
