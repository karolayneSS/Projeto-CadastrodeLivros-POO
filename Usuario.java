public class Usuario {
    String nome;
    long matricula;
    Emprestimo[] emprestimos = new Emprestimo[3];
    int totalEmprestimos = 0; 

    Usuario(String nome, long matricula){
        this.nome=nome;
        this.matricula=matricula;
    }

    void adicionarEmprestimo(Emprestimo e){
        if (totalEmprestimos<emprestimos.length){
            emprestimos[totalEmprestimos]=e;
            totalEmprestimos++;
        }else{
            System.out.println("Limite de empréstimo atingido!");
        }

    }

    double totalMultas(){
        double soma =0;
        for (int i=0; i<totalEmprestimos; i++){
            soma+=emprestimos[i].multa;
        }
        return soma; 
    }

    void listarEmprestimos(){
        System.out.println("\n Histórico de empréstimo de " + nome + ": ");
        System.out.println();
        
        for (int i=0; i<totalEmprestimos; i++){
            System.out.println(emprestimos[i]);
        }

    }

    

}
