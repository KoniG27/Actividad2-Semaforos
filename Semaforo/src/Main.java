public class Main {
    public static void main(String[] args) {
        ResourceControl resourceControl = new ResourceControl(10);
        Process[] processes = new Process[5];

        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process(resourceControl, i + 1);
            processes[i].start();
        }

        for (int i = 0; i < processes.length; i++) {
            try {
                processes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Process extends Thread {
    private ResourceControl resourceControl;
    private int processId;

    public Process(ResourceControl resourceControl, int processId) {
        this.resourceControl = resourceControl;
        this.processId = processId;
    }

    @Override
    public void run() {
        int r = (int) (Math.random() * 5) + 1;
        int l = (int) (Math.random() * 5) + 1;

        try {
            System.out.println("Proceso " + processId + " esta intentando reservar " + r + " unidades");
            resourceControl.reserve(r);
            System.out.println("Proceso " + processId + " reservo " + r + " unidades");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("Proceso " + processId + " esta intentando liberar " + l + " unidades");
            resourceControl.release(l);
            System.out.println("Proceso " + processId + " libero " + l + " unidades");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
