import java.util.Random;
import java.util.Scanner;

public class Player extends Character {
    static int d12() {
        Random d12 = new Random();
        return d12.nextInt(12) + 1;
    }

    static int d20() {
        Random d20 = new Random();
        return d20.nextInt(20) + 1;
    }

    static int ataqueComputer() {
        Random gerador = new Random();
        return gerador.nextInt(3) + 1;

    }

    static int ataquePlayer() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Escolha seu ataque");
        System.out.println("(1) - Acerto Decisivo");
        System.out.println("(2) - Coragem");
        System.out.println("(3) - Justiça Demaciana");
        System.out.println("(4) - Descansar");
        return leia.nextInt();
    }

    static void vidaImprime() {
        System.out.println("Vida player ");
        System.out.println("Vida computador ");
        System.out.println("Contagem especial ");

    }

    public Player(String nome, int vida, int ca, int danoBase) {
        super(nome, vida, ca, danoBase);

    }

    public void batalha() {
        int tryAgain = 1;
        int xp = 1;
        double a=2,b=2;
        int vidaComputador = 10;
        int contagemEspecial = 5;
        int escolhaAtaque;
        int i = 2;
        Scanner read = new Scanner(System.in);
        while (tryAgain == 1) {
            int teste = 0;
            int vidaPlayer = getVida();

            while (vidaPlayer > 0) {
                if (xp % 10 == 0) {
                    vidaPlayer= getVida() + 2;
                    setDanoBase(getDanoBase() + 2);
                    contagemEspecial = 5;
                    b+=b;
                }

                i++;
                vidaComputador = i + 10;

                while (vidaPlayer > 0 && vidaComputador > 0) {
                    imprimeVida(vidaPlayer, vidaComputador, contagemEspecial);
                    escolhaAtaque = ataquePlayer();
                    Random d20 = new Random();
                    if (teste == 0) {
                        switch (escolhaAtaque) {

                            case 1:
                                teste = 0;
                                if (d20() > 12) {
                                    System.out.printf("O %s aplicou acerto decisivo %n", getNome());

                                    vidaComputador -= (d12() + getDanoBase());
                                } else if (d20() == 1) {
                                    System.out.printf("Ao levantar a espada e preparar o ataque voce tropeçou e caiu de cara no chão%n");
                                    vidaPlayer -= 1;
                                    teste++;
                                } else {
                                    System.out.println("Voce errou");
                                }

                                break;
                            case 2:
                                System.out.printf("O %s efetuou coragem %n ", getNome());
                                somaCa(2);
                                break;
                            case 3:
                                if(contagemEspecial > 0) {
                                    System.out.printf("O %s aplicou justiça demaciana %n", getNome());
                                    vidaComputador -= (d12() * 2 + getDanoBase());
                                    contagemEspecial--;
                                    break;
                                }
                            case 4:
                                System.out.print("Voce descansou%n");
                                contagemEspecial++;
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Perdeu o turno pra se levantar");
                        teste = 0;
                    }
                    if (vidaComputador > 0) {
                        escolhaAtaque = ataqueComputer();
                        switch (escolhaAtaque) {
                            case 1:
                                if (d20() > getCa()) {
                                    System.out.println("Computador aplicou soco");
                                    vidaPlayer -= 10;
                                    break;
                                } else {
                                    System.out.println("Computador errou ");
                                }
                            case 2:
                                if (d20() > getCa()) {
                                    System.out.println("Computador aplicou espada flamejante");
                                    vidaPlayer -= 25;
                                    break;
                                } else {
                                    System.out.println("Computador errou ");
                                }
                            case 3:
                                if (d20() > getCa()) {
                                    System.out.println("Computador aplicou especial");
                                    break;
                                } else {
                                    System.out.println("Computador errou ");
                                }
                        }
                    } else {
                        System.out.println("Computador morreu ");
                        xp ++;
                    }
                }
            }
            System.out.println("Voce morreu aperte 1 para reviver e 2 para descansar eternamente ");
            tryAgain = read.nextInt();
        }
    }
}