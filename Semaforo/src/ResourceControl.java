import java.util.concurrent.Semaphore;

public class ResourceControl {
    private Semaphore semaphore;
    private int resourceCount;

    public ResourceControl(int resourceCount) {
        this.semaphore = new Semaphore(resourceCount);
        this.resourceCount = resourceCount;
    }

    public void reserve(int r) throws InterruptedException {
        semaphore.acquire(r);
    }

    public void release(int l) {
        semaphore.release(l);
    }
}