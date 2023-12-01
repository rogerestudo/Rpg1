import java.util.Scanner;

public class Character {
    private String nome;
    private Boolean vivo=true;
    private int vida;
    private int ca;
    private int danoBase;
    static void imprimeVida(int vidaUsuario, int vidaComputador, int contagemEspeciais)
    {
        System.out.println("===========");
        System.out.println("- Vida Usuario " + vidaUsuario);
        System.out.println("- Vida Computador " + vidaComputador);
        System.out.println("Contagem Especiais " + contagemEspeciais);
        System.out.println("===========");
    }
    public Character(String nome,int vida, int ca, int danoBase )
    {
        this.nome = nome;
        this.vivo = true;
        this.vida = vida;
        this.ca = ca;
        this.danoBase = danoBase;

    }
    public String getNome()
    {
        return this.nome;
    }
    public Boolean getVivo()
    {
        return this.vivo;
    }
    public void setVivo(Boolean vivo)
    {
        this.vivo=vivo;
    }
    public int getVida()
    {
        return this.vida;
    }
    public void setVida(int vida)
    {
        this.vida = vida;
    }
    public int getCa()
    {
        return this.ca;
    }
    public void setCa(int ca)
    {
        this.ca = ca;
    }
    public void somaCa(int a)
    {
        ca+=a;
    }
    public int getDanoBase()
    {
        return this.danoBase;
    }
    public void setDanoBase(int danoBase)
    {
        this.danoBase = danoBase;
    }

}
