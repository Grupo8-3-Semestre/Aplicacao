package sptech.school.voveaplication.service.filaobj;

public class FilaObj<T> {
    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int capaciade) {
        tamanho = 0;
        fila =  (T[]) new Object[capaciade];
    }

    public boolean isEmpty() {
        if(tamanho == 0){
            return true;
        }
        return false;
    }
    public boolean isFull() {
        if(tamanho == fila.length){
            return true;
        }
        return false;
    }

    public void insert(T info) {
        if(isFull()){
            throw new IllegalStateException("Fila cheia!");
        }
        fila[tamanho++] = info;
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public T peek() {
        if(isEmpty()){
            return null;
        }
        return fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public T poll() {
        T aux = fila[0];
        if(isEmpty()){
            return null;
        }
        for(int i = 0; i < tamanho -1; i++){
            fila[i] = fila[i+1];
        }
        tamanho--;
        fila[tamanho]= null;
        return aux;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        if(isEmpty()){
            System.out.println("Fila vazia");
        }
        for(int i = 0; i < tamanho; i++){
            System.out.println(fila[i]);
        }
    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho(){
        return tamanho;
    }
}

