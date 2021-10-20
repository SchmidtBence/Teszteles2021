public class Teglalap {
    private int a;
    private int b;

    public Teglalap(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int szamitTerulet(int a,int b){
        if(a == 0 || b == 0){
            throw new IllegalArgumentException();
        }
        return a*b;
    }
}
