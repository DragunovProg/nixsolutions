package ua.dragunov.exception;

public class Retry {


    public void retry(int delay, int attempts, Block block) throws InterruptedException {
        int countAttempts = 0;

        while (true) {
            try {
                block.run();
                break;
            } catch (Exception e) {
                System.out.println("Exception , try again");
                if (countAttempts++ == attempts) throw e ;
                Thread.sleep(delay * countAttempts);
            }
        }
    }


}
