package lian.demo;

public class VolatileDemo {
    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            	System.out.println("1Æô¶¯");
                while (!isOver) ;
                System.out.println("1½áÊø");
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
        System.out.println("½áÊø");
    }
}