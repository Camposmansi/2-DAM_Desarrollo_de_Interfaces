package Curso.HundirFlota;

import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {
    static final char AGUA_NO_TOCADO = '.';
    static final char AGUA = 'A';
    static final char TOCADO = 'X';
    static final int TAMANIO = 10;
    private static Scanner sc;

    public HundirLaFlota() {
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        char[][] mapaUsuario = new char[10][10];
        char[][] mapaOrdenador = new char[10][10];
        char[][] mapaOrdenadorParaUsuario = new char[10][10];
        int puntosUsuario = 24;
        int puntosOrdenador = 24;
        boolean juegoTerminado = false;
        boolean tiroCorrecto = false;
        int[] tiro = new int[2];
        inicializacion(mapaUsuario, mapaOrdenador);
        inicializaMapaRegistro(mapaOrdenadorParaUsuario);

        while(!juegoTerminado) {
            System.out.println("MAPA DEL USUARIO");
            imprimirMapa(mapaUsuario);
            System.out.printf("PUNTOS RESTANTES DEL JUGADOR: %d\n", puntosUsuario);
            System.out.println("TURNO DEL JUGADOR");
            tiroCorrecto = false;

            while(true) {
                while(!tiroCorrecto) {
                    tiro = pedirCasilla();
                    if (tiro[0] != -1 && tiro[1] != -1) {
                        tiroCorrecto = evaluarTiro(mapaOrdenador, tiro);
                        if (!tiroCorrecto) {
                            System.out.println("TIRO INCORRECTO");
                        }
                    } else {
                        System.out.println("TIRO INCORRECTO");
                    }
                }

                int puntosOrdenadorAnterior = puntosOrdenador;
                puntosOrdenador = actualizarMapa(mapaOrdenador, tiro, puntosOrdenador);
                char tipoTiro = (char) (puntosOrdenadorAnterior - puntosOrdenador > 0 ? 88 : 65);
                actualizarMapaRegistro(mapaOrdenadorParaUsuario, tiro, (char)tipoTiro);
                System.out.println("\nREGISTRO DEL MAPA DEL ORDENADOR");
                imprimirMapa(mapaOrdenadorParaUsuario);
                juegoTerminado = puntosOrdenador == 0;
                if (!juegoTerminado) {
                    System.out.printf("PUNTOS RESTANTES DEL ORDENADOR: %d\n\n", puntosOrdenador);
                    System.out.println("TURNO DEL ORDENADOR");

                    for(tiroCorrecto = false; !tiroCorrecto; tiroCorrecto = evaluarTiro(mapaUsuario, tiro)) {
                        tiro = generaDisparoAleatorio();
                    }
                }

                puntosUsuario = actualizarMapa(mapaUsuario, tiro, puntosUsuario);
                juegoTerminado = puntosUsuario == 0;
                break;
            }
        }

        if (puntosOrdenador == 0) {
            System.out.println("EL VENCEDOR HA SIDO EL JUGADOR");
        } else {
            System.out.println("EL VENCEDOR HA SIDO EL ORDENADOR");
        }

        sc.close();
    }

    private static int[] generaDisparoAleatorio() {
        return new int[]{aleatorio(), aleatorio()};
    }

    public static void inicializacion(char[][] m1, char[][] m2) {
        inicializaMapa(m1);
        inicializaMapa(m2);
    }

    private static void inicializaMapaRegistro(char[][] mapa) {
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j) {
                mapa[i][j] = '.';
            }
        }
    }

    private static void inicializaMapa(char[][] mapa) {
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 10; ++j) {
                mapa[i][j] = '.';
            }
        }

        int[] barcos = new int[]{5, 5, 3, 3, 3, 1, 1, 1, 1, 1};
        char[] direccion = new char[]{'V', 'H'};
        int[] var6 = barcos;
        int var5 = barcos.length;

        label98:
        for(int var4 = 0; var4 < var5; ++var4) {
            int b = var6[var4];
            boolean colocado = false;

            while(true) {
                int fila;
                int columna;
                boolean otro;
                int j;
                do {
                    do {
                        while(true) {
                            if (colocado) {
                                continue label98;
                            }

                            fila = aleatorio();
                            columna = aleatorio();
                            char direcc = direccion[aleatorio() % 2];
                            if (direcc == 'V') {
                                break;
                            }

                            if (columna + b <= 9) {
                                otro = false;

                                for(j = columna; j <= columna + b && !otro; ++j) {
                                    if (mapa[fila][j] != '.') {
                                        otro = true;
                                    }
                                }

                                if (!otro) {
                                    for(j = columna; j < columna + b; ++j) {
                                        mapa[fila][j] = Integer.toString(b).charAt(0);
                                    }

                                    colocado = true;
                                }
                            }
                        }
                    } while(fila + b > 9);

                    otro = false;

                    for(j = fila; j <= fila + b && !otro; ++j) {
                        if (mapa[j][columna] != '.') {
                            otro = true;
                        }
                    }
                } while(otro);

                for(j = fila; j < fila + b; ++j) {
                    mapa[j][columna] = Integer.toString(b).charAt(0);
                }
                colocado = true;
            }
        }

    }

    private static int aleatorio() {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(10);
    }

    public static void imprimirMapa(char[][] mapa) {
        char[] letras = new char[10];

        int i;
        for(i = 0; i < 10; ++i) {
            letras[i] = (char)(65 + i);
        }

        System.out.print("    ");

        for(i = 0; i < 10; ++i) {
            System.out.print("[" + i + "] ");
        }

        System.out.println("");

        for(i = 0; i < 10; ++i) {
            System.out.print("[" + letras[i] + "]  ");

            for(int j = 0; j < 10; ++j) {
                System.out.print(mapa[i][j] + "   ");
            }
            System.out.println("");
        }
    }

    private static int[] pedirCasilla() {
        System.out.println("Introduzca la casilla (por ejemplo B4): ");
        String linea = sc.nextLine();
        linea = linea.toUpperCase();
        int[] t;
        if (linea.matches("^[A-Z][0-9]*$")) {
            char letra = linea.charAt(0);
            int fila = Character.getNumericValue(letra) - Character.getNumericValue('A');
            int columna = Integer.parseInt(linea.substring(1, linea.length()));
            if (fila >= 0 && fila < 10 && columna >= 0 && columna <= 10) {
                t = new int[]{fila, columna};
            } else {
                t = new int[]{-1, -1};
            }
        } else {
            t = new int[]{-1, -1};
        }
        return t;
    }

    public static boolean evaluarTiro(char[][] mapa, int[] t) {
        int fila = t[0];
        int columna = t[1];
        return mapa[fila][columna] == '.' || mapa[fila][columna] >= '1' && mapa[fila][columna] <= '5';
    }

    private static int actualizarMapa(char[][] mapa, int[] t, int puntos) {
        int fila = t[0];
        int columna = t[1];
        if (mapa[fila][columna] == '.') {
            mapa[fila][columna] = 'A';
            System.out.println("AGUA");
        } else {
            mapa[fila][columna] = 'X';
            System.out.println("HAS ALCANZADO A ALGÚN BARCO");
            --puntos;
        }
        return puntos;
    }

    private static void actualizarMapaRegistro(char[][] mapa, int[] t, char valor) {
        int fila = t[0];
        int columna = t[1];
        mapa[fila][columna] = valor;
    }
}

