import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Ats ats = new Ats();
        Specialist specialist = new Specialist(ats);
        ExecutorService poolSpecialists = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Thread atsThread = new Thread(ats);
        atsThread.start();

        poolSpecialists.submit(specialist);
        poolSpecialists.submit(specialist);
        poolSpecialists.submit(specialist);
        poolSpecialists.submit(specialist);

        poolSpecialists.shutdown();
        try {
            poolSpecialists.awaitTermination(60, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ats.getIncomingCalls().forEach(f -> System.out.print(f.getName() + " "));
        System.out.println();
    }
}
