import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Puente puente = new Puente();
        Random num = new Random();
        int cochesnorte = num.nextInt(5);
        int cochessur = num.nextInt(5);

        // Crear un hilo para cada coche que viene del norte
        for (int i = 1; i <= cochesnorte; i++) {
            final int NumCoche = i;
            new Thread(() -> {
                try {
                    puente.cruzanNorte(NumCoche);
                    Thread.sleep(1000);
                    puente.salenNorte(NumCoche);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Crear un hilo para cada coche que viene del sur
        for (int i = 1; i <= cochessur; i++) {
            final int NumCoche = i;
            new Thread(() -> {
                try {
                    puente.cruzanSur(NumCoche);
                    Thread.sleep(1000);
                    puente.salenSur(NumCoche);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


