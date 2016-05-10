package Principal;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mapa {

    int altura, anchura, banderaX, banderaY,
    baseX, baseY, posX, posY;
    char[][] mapaMatriz;
    Mapa padre = null;

    public Mapa(){}

    public Mapa(Mapa copia, int y, int x){

        this.altura = copia.altura;
        this.anchura = copia.anchura;
        this.banderaX = copia.banderaX;
        this.banderaY = copia.banderaY;
        this.posX = x;
        this.posY = y;
        this.padre = copia;
        this.mapaMatriz = copia.mapaMatriz;

//        System.out.println("---------------------------------------------------");
//
////        for(int i = 0; i < this.altura; i++){
////            for(int j = 0; j < this.anchura; j++){
////                System.out.print(mapaMatriz[j][i]);
////            }
////            System.out.println();
////        }
//
//        System.out.println(this.posX);
//        System.out.println(this.posY);
//
//        System.out.println("---------------------------------------------------");

    }

    public void actualizarMapa(String mapa){

        String[] parts = mapa.split(",");

        int indice;

        // Si es el primer mapa (altura, anchura, posición y mapa),
        // toma los datos de este y actualiza el índice
        if (parts.length > 3){
            this.anchura = Integer.parseInt(parts[0]);
            this.altura = Integer.parseInt(parts[1]);
            this.posX = Integer.parseInt(parts[4]);
            this.posY = Integer.parseInt(parts[5]);
            indice = 6;
            this.mapaMatriz = new char[this.anchura][this.altura];

        // Sino actualiza el índice correspondiente
        }else {
            indice = 2;
            this.posX = Integer.parseInt(parts[0]);
            this.posY = Integer.parseInt(parts[1]);
        }

            int k = 0;

            for(int i = 0; i < this.altura; i++){
                for(int j = 0; j < this.anchura; j++){
                    mapaMatriz[j][i] = parts[indice].charAt(k);
                    if(mapaMatriz[j][i] != ' ' || mapaMatriz[j][i] != 'H'){
                        if(mapaMatriz[j][i] == 'A') {
                            banderaX = i;
                            banderaY = j;
                        }else if(mapaMatriz[j][i] == 'W') {
                            baseX = i;
                            baseY = j;
                        }
                    }

                    k++;
                }
        }

        System.out.println(this.posX);
        System.out.println(this.posY);

        for(int i = 0; i < this.altura; i++){
            for(int j = 0; j < this.anchura; j++){
                System.out.print(mapaMatriz[j][i]);
            }
            System.out.println();
        }

    }

    public void generarHijos(){

        ArrayList hijos = new ArrayList();

        System.out.println("Altura: " + this.altura + ", anchura: " + this.anchura);

        if(this.mapaMatriz[this.posY][this.posX-1] != 'H'){
            hijos.add(new Mapa(this, this.posY, this.posX-1));
        }
        if(mapaMatriz[this.posY+1][this.posX-1] != 'H'){
            hijos.add(new Mapa(this, this.posY+1, this.posX-1));
        }
        if(mapaMatriz[this.posY+1][this.posX] != 'H'){
            hijos.add(new Mapa(this, this.posY+1, this.posX));
        }
        if(mapaMatriz[this.posY+1][this.posX+1] != 'H'){
            hijos.add(new Mapa(this, this.posY+1, this.posX+1));
        }
        if(mapaMatriz[this.posY][this.posX+1] != 'H'){
            hijos.add(new Mapa(this, this.posY, this.posX+1));
        }
        if(mapaMatriz[this.posY-1][this.posX+1] != 'H'){
            hijos.add(new Mapa(this, this.posY-1, this.posX+1));
        }
        if(mapaMatriz[this.posY-1][this.posX] != 'H'){
            hijos.add(new Mapa(this, this.posY-1, this.posX));
        }
        if(mapaMatriz[this.posY-1][this.posX-1] != 'H'){
            hijos.add(new Mapa(this, this.posY-1, this.posX-1));
        }

        hijos.get(0).toString();

        for(int i=0; i < hijos.size();i++){

            System.out.println(hijos.get(i).toString());
        }

    }

    public String toString(){
        String s;
        s = (this.posX + ", " + this.posY);
        return s;
    }
}
