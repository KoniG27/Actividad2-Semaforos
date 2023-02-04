public class Main {
    public static void main(String[] args) {
        RecursosControl recursosControl = new RecursosControl(20);
        Proceso[] procesos = new Proceso[5];

        for (int i = 0; i < procesos.length; i++) {
            procesos[i] = new Proceso(recursosControl, i + 1);
            procesos[i].start();
        }

        for (int i = 0; i < procesos.length; i++) {
            try {
                procesos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Proceso extends Thread {
    private RecursosControl recursosControl;
    private int procesoId;

    public Proceso(RecursosControl recursosControl, int procesoId) {
        this.recursosControl = recursosControl;
        this.procesoId = procesoId;
    }

    @Override
    public void run() {
        int r = (int) (Math.random() * 5) + 1;
        int l = (int) (Math.random() * 5) + 1;

        try {
            System.out.println("Proceso " + procesoId + " esta intentando reservar " + r + " unidades");
            recursosControl.reserve(r);
            System.out.println("Proceso " + procesoId + " reservo " + r + " unidades");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("Proceso " + procesoId + " esta intentando liberar " + l + " unidades");
            recursosControl.release(l);
            System.out.println("Proceso " + procesoId + " libero " + l + " unidades");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}