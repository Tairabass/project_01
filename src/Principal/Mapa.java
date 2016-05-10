package Principal;

import java.util.ArrayList;

public class Mapa {

    int altura, anchura, banderaX, banderaY,
    baseX, baseY, posX, posY;
    char[][] mapaMatriz;
    Mapa padre = null;

    public Mapa(){}

    public Mapa(Mapa copia, int x, int y){

        this.altura = copia.altura;
        this.anchura = copia.anchura;
        this.banderaX = copia.banderaX;
        this.banderaY = copia.banderaY;
        this.posX = x;
        this.posY = y;
        this.padre = copia;

        System.out.println("---------------------------------------------------");

        for(int i = 0; i < this.altura; i++){
            for(int j = 0; j < this.anchura; j++){
                System.out.print(mapaMatriz[j][i]);
            }
            System.out.println();
        }

        System.out.println(this.posX);
        System.out.println(this.posY);

        System.out.println("---------------------------------------------------");

    }

    public void actualizarMapa(String mapa){

        String[] parts = mapa.split(",");

        int indice;

        // Si es el primer mapa (altura, anchura, posición y mapa),
        // toma los datos de este y actualiza el índice
        if (parts.length > 3){
            this.anchura = Integer.parseInt(parts[0]);
            this.altura = Integer.parseInt(parts[1]);
            this.posX = Integer.parseInt(parts[3]);
            this.posY = Integer.parseInt(parts[4]);
            indice = 6;
            this.mapaMatriz = new char[this.anchura][this.altura];

        // Sino actualiza el índice correspondiente
        }else
            indice = 2;

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

        System.out.println(this.banderaX);
        System.out.println(this.banderaY);

        for(int i = 0; i < this.altura; i++){
            for(int j = 0; j < this.anchura; j++){
                System.out.print(mapaMatriz[j][i]);
            }
            System.out.println();
        }

    }

    public void generarHijos(){

        ArrayList hijos = new ArrayList();

        if(mapaMatriz[posX-1][posY] != 'H'){
            hijos.add(new Mapa(this, this.posX-1, this.posY));
        }
        if(mapaMatriz[posX-1][posY+1] != 'H'){

        }
        if(mapaMatriz[posX][posY+1] != 'H'){

        }
        if(mapaMatriz[posX+1][posY+1] != 'H'){

        }
        if(mapaMatriz[posX+1][posY] != 'H'){

        }
        if(mapaMatriz[posX+1][posY-1] != 'H'){

        }
        if(mapaMatriz[posX][posY-1] != 'H'){

        }
        if(mapaMatriz[posX-1][posY-1] != 'H'){

        }

    }

}
