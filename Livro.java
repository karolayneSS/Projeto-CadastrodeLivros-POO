public class Livro {

    String titulo;
    String autor;
    long isbn;
    boolean disponivel = true;

    public Livro(String titulo, String autor, long isbn){
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
    }

    public String toString(){
        String status;

        if (disponivel){
            status="disponivel";
        }else{
            status="indisponivel";

        }
        return titulo + "-" + status;
    }




}