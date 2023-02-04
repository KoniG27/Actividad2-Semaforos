class Puente {
    private int cochesdelnorte = 0;
    private int cochesdelsur = 0;

    public synchronized void cruzanNorte(int NumCoche) throws InterruptedException {
        while (cochesdelsur > 0) {
            wait();
        }
        cochesdelnorte++;
        System.out.println("Coche del norte con id: " + NumCoche + " esta cruzando el puente.");
    }

    public synchronized void cruzanSur(int NumCoche) throws InterruptedException {
        while (cochesdelnorte > 0) {
            wait();
        }
        cochesdelsur++;
        System.out.println("Coche del sur con id: " + NumCoche + " esta cruzando el puente.");
    }

    public synchronized void salenNorte(int NumCoche) {
        cochesdelnorte--;

        System.out.println("Coche del norte con id: " + NumCoche + " ha salido del puente.");
        notifyAll();
    }

    public synchronized void salenSur(int NumCoche) {
        cochesdelsur--;
        System.out.println("Coche del sur con id: " + NumCoche + " ha salido del puente.");
        notifyAll();
    }
}