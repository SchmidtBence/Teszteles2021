package emberek;
import java.util.*;

public class EmberekLista {
    private ArrayList<String> emberek;

    public EmberekLista() {
        super();
        this.emberek = new ArrayList<String>();
    }

    public ArrayList<String> getEmberek() {
        return emberek;
    }

    public void setEmberek(ArrayList<String> emberek) {
        this.emberek = emberek;
    }

    public void add(String ember){
        if (!this.emberek.contains(ember)){
            this.emberek.add(ember);
        }

    }

    public int size(){
        return this.emberek.size();
    }

    public boolean isEmpty(){
        return this.emberek.isEmpty();
    }

    public void removeAll() {
        this.emberek.clear();
    }

    public void remove(String ember){
        if (this.emberek.contains(ember)){
            this.emberek.remove(ember);
            return;
        }
        throw new NoSuchElementException();
    }
}
