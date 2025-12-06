import java.util.Date;

public class Main { 
    public static void main(String[] args) {

        Livro l1 = new Livro("o Hobbit", "Tolkien", 111);
        Livro l2 = new Livro("A ultima lagrima", "Odete Guimaraes Gontijo", 124);
        Livro l3= new Livro("Dom casmurro","Machado", 342);
        Livro l4=new Livro("É assim que acaba", "Colen", 224);

        Usuario u1 = new Usuario("Karolayne",145);

        Emprestimo e1 = new Emprestimo(u1, l1);
        Emprestimo e2 = new Emprestimo(u1, l2);
        Emprestimo e3 = new Emprestimo(u1, l3);

        Emprestimo e4 = null;
        try {
            e4= new Emprestimo(u1, l4);
        } catch (Exception ex){
            System.out.println("\n Erro:  " + ex.getMessage());
        }

        Date devolucao = new Date(e1.dataEmprestimo.getTime() + (20L * 24 * 60 * 60 * 1000));
        e1.devolver(devolucao);

        System.out.println("\n Livros Disponiveis: ");
        Livro[] listaLivros = { l1, l2, l3, l4};
        
        for (Livro l : listaLivros)
            if (l.disponivel)
               System.out.println("-  " + l.titulo);
        
               u1.listarEmprestimos();

               System.out.println("\n Multas totais: R$  " + u1.totalMultas());

        
    }
    
}
