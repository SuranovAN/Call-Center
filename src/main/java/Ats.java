import java.util.concurrent.ConcurrentLinkedQueue;

public class Ats extends Thread {
    public static boolean stop = false;
    private volatile ConcurrentLinkedQueue<Call> incomingCalls = new ConcurrentLinkedQueue<>();

    public ConcurrentLinkedQueue<Call> getIncomingCalls() {
        return incomingCalls;
    }

    @Override
    public void run() {
        int i = 0;
        int n = 0;
        while(i < 2) {
            for (int j = 0; j < 60; j++) {
                incomingCalls.add(new Call("Звонок " + n));
                n++;
            }
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
