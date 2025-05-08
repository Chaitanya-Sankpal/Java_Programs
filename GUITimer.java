import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class GUITimer extends JFrame {
    private JLabel timeLabel;
    private JButton startBtn, stopBtn, lapBtn, resetBtn;
    private JTextArea lapArea;
    private long startTime;
    private boolean running = false;
    private Thread timerThread;
    private int lapCount = 0;

    public GUITimer() {
        setTitle("Lap Counter");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Time Display
        timeLabel = new JLabel("00:00:000", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel, BorderLayout.NORTH);

        // Control Buttons
        JPanel panel = new JPanel();
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        lapBtn = new JButton("Lap");
        resetBtn = new JButton("Reset");

        startBtn.addActionListener(e -> startTimer());
        stopBtn.addActionListener(e -> stopTimer());
        lapBtn.addActionListener(e -> lapTimer());
        resetBtn.addActionListener(e -> resetTimer());

        panel.add(startBtn);
        panel.add(stopBtn);
        panel.add(lapBtn);
        panel.add(resetBtn);
        add(panel, BorderLayout.CENTER);

        // Lap History Area
        lapArea = new JTextArea(5, 20);
        lapArea.setEditable(false);
        add(new JScrollPane(lapArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startTimer() {
        if (!running) {
            running = true;
            startTime = System.currentTimeMillis();
            lapCount = 0;
            lapArea.append("Started at: 00:00:000\n");
           // JOptionPane.showMessageDialog(this, "Timer Started", "Info", JOptionPane.INFORMATION_MESSAGE);

            timerThread = new Thread(() -> {
                while (running) {
                    long now = System.currentTimeMillis();
                    long elapsed = now - startTime;
                    String timeText = formatTime(elapsed);

                    SwingUtilities.invokeLater(() -> timeLabel.setText(timeText));

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            timerThread.start();
        }
    }

    public void stopTimer() {
        if (running) {
            running = false;
            if (timerThread != null && timerThread.isAlive()) {
                timerThread.interrupt();
            }

            long now = System.currentTimeMillis();
            long elapsed = now - startTime;
            String stopTime = formatTime(elapsed);
            lapArea.append("Stopped at: " + stopTime + "\n");
            //JOptionPane.showMessageDialog(this, "Timer Stopped at: " + stopTime, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void resetTimer() {
        stopTimer();
        lapCount = 0;
        timeLabel.setText("00:00:000");
        lapArea.setText("");
    }

    public void lapTimer() {
        if (running) {
            lapCount++;
            long now = System.currentTimeMillis();
            long elapsed = now - startTime;
            String lapTime = formatTime(elapsed);

            String entryMessage = ">>> Lap " + lapCount + " Entry\nLap " + lapCount + ": " + lapTime;
            lapArea.append(entryMessage + "\n");
           // JOptionPane.showMessageDialog(this, entryMessage, "Lap Entry Recorded", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String formatTime(long ms) {
        long minutes = (ms / 60000) % 60;
        long seconds = (ms / 1000) % 60;
        long milliseconds = ms % 1000;
        return String.format("%02d:%02d:%03d", minutes, seconds, milliseconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUITimer());
    }
}
