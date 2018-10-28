import javax.swing.SwingUtilities;

public class Main {

    public static void main(String args[]) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                try {
                    new Game();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
