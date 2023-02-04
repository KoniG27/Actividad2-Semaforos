import java.util.concurrent.Semaphore;

public class RecursosControl {
    private Semaphore semaphore;
    private int recursosCuent;

    public RecursosControl(int recursosCuent) {
        this.semaphore = new Semaphore(recursosCuent);
        this.recursosCuent = recursosCuent;
    }

    public void reserve(int r) throws InterruptedException {
        semaphore.acquire(r);
    }

    public void release(int l) {
        semaphore.release(l);
    }
}