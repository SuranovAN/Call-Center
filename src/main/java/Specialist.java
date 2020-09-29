import java.util.concurrent.ThreadPoolExecutor;

public class Specialist implements Runnable {
    private final int resolveTime = 3000;
    Ats ats = new Ats();

    public Specialist(Ats ats) {
        this.ats = ats;
    }

    @Override
    public void run() {
        while (!Ats.stop) {
            Call s = ats.getIncomingCalls().poll();
            try {
                Thread.sleep(resolveTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " решил проблему " + s.getName());
        }
    }
}
