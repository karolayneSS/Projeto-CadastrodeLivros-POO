import java.util.Date;
import java.text.SimpleDateFormat;

public class Emprestimo {
    Usuario usuario;
    Livro livro;
    Date dataEmprestimo;
    Date dataPrevista;
    Date dataDevolucao;
    boolean finalizado = false;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    double multa=0;


    Emprestimo(Usuario usuario, Livro livro){

        if (!livro.disponivel) throw new RuntimeException("Livro indisponivel");

        if (usuario.totalEmprestimos>= usuario.emprestimos.length) throw new RuntimeException("Limite de empréstimo atingido!");
            
        this.usuario=usuario;
        this.livro=livro;
        this.dataEmprestimo=new Date();
        this.dataPrevista = new Date(this.dataEmprestimo.getTime() + (14L * 24 * 60 * 60 * 1000));
        livro.disponivel=false;
        usuario.adicionarEmprestimo(this);
    }
    void devolver(Date dataDev){
        this.dataDevolucao=dataDev;
        this.finalizado=true;
        this.livro.disponivel=true;

        long diff = dataDev.getTime() - dataEmprestimo.getTime();
        long dias = diff/(1000 * 60*60*24);
        if (dias>14) multa = (dias-14)*1.5;
    }

    public String toString(){
        String texto = livro.titulo+ "  | Emprestimo em: " + sdf.format(dataEmprestimo) + " | Data prevista para entrega:  " + sdf.format(dataPrevista);
        if (finalizado)
            texto+= "   |  Devolvido em:  " + sdf.format(dataDevolucao) + "   |  Multa de: R$ " + multa;
        return texto;
    }
}
