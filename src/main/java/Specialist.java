import java.util.concurrent.ThreadPoolExecutor;

public class Specialist implements Runnable {
    private final int resolveTime = 3000;

    @Override
    public void run() {
        while (!Ats.stop) {
            Call s = Ats.incomingCalls.poll();
            try {
                Thread.sleep(resolveTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assert s != null;
            System.out.println(Thread.currentThread().getName() + " решил проблему " + s.getName());
        }
    }
}
