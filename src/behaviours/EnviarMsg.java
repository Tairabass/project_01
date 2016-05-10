package behaviours;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;


public class EnviarMsg extends OneShotBehaviour{

    String servidor, contenido;
    int intencion;
    boolean firstConect;

    public EnviarMsg(String servidor, String contenido, int intencion, boolean firstConect){
        this.servidor = servidor;
        this.contenido = contenido;
        this.intencion = intencion;
        this.firstConect = firstConect;
    }

    public void action() {

        ACLMessage mensaje = new ACLMessage(intencion);
        mensaje.addReceiver(new AID(servidor, AID.ISLOCALNAME));
        mensaje.setContent(contenido);
        // Si es la primera conexión establece el protocolo
        if (firstConect){
            mensaje.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
            myAgent.addBehaviour(new Protocolo(myAgent, mensaje));
        }
        else
            myAgent.send(mensaje);


    }

}
