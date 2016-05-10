package behaviours;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

public class Servidor extends Behaviour {

    public void action() {

        ServiceDescription sd = new ServiceDescription();
        DFAgentDescription template = new DFAgentDescription();
        sd.setType("CTF");
        template.addServices(sd);
        AID[] creadores = null;
        try {

            DFAgentDescription[] result = DFService.search(myAgent, template);
            creadores = new AID[result.length];
            for (int i = 0; i < result.length; i++)
                creadores[i] = result[i].getName();

        } catch (FIPAException fe) {
            creadores = null;
            fe.printStackTrace();

        }
        if (creadores == null) {
            myAgent.doDelete();
        }

        myAgent.addBehaviour(new EnviarMsg(creadores[0].getLocalName(),"8",ACLMessage.REQUEST,true));

    }

    @Override
    public boolean done() {
        return true;
    }

}

/*
public class behaviours.Servidor extends Behaviour {

    @Override
    public void action(){

        ServiceDescription sd = new ServiceDescription();
        DFAgentDescription template = new DFAgentDescription();
        sd.setType("CFT");
        template.addServices(sd);
        AID[] creadores = null; // TODO modificar creadores

        try{

            DFAgentDescription[] result = DFService.search(myAgent, template);
            creadores = new AID[result.length]; // TODO modificar creadores
            creadores[0] = result[0].getName(); // TODO modificar creadores

            if(result.length <= 0)
                myAgent.doDelete();
            else
                myAgent.addBehaviour(new behaviours.EnviarMsg(creadores[0].getLocalName(),"7", ACLMessage.REQUEST, true)); // TODO modificar creadores


        }catch(FIPAException fexcept){
            fexcept.printStackTrace();
        }


    }

    @Override
    public boolean done(){return true;}

}
*/