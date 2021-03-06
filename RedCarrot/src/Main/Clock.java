package Main;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Clock extends JComponent {

    private static final Color INTEGRAL_COLOR = new Color(0, 128, 128);
    private int radius;
    private Calendar currentTime = Calendar.getInstance();
    private double s = 0.03;

    public Clock(int radius) {
        this.radius = radius;
    }

    public void setCurrentTime(Date time) {
        this.currentTime.setTime(time);
    }

    public void setCurrentTime(long millis) {
        this.currentTime.setTimeInMillis(millis);
    }

    public Dimension getPreferredSize() {
        Insets insets = getInsets();
        int r = (int) (radius == -1 ? 0 : radius * (1 + s)) + 1;
        return new Dimension(r * 2 + insets.left + insets.right, r * 2
                + insets.top + insets.bottom);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Insets insets = getInsets();
        int wid = getWidth() - insets.left - insets.right;
        int hei = getHeight() - insets.top - insets.bottom;
        int r = (int) ((Math.min(wid, hei)) / 2 / (1 + s));
        g2d.translate(insets.left + r * (1 + s), insets.top + r * (1 + s));
        g2d.scale(1, -1);
        for (int i = 0; i < 60; i++) {
            int angle = 90 - i * 6;
            double pos[] = calcPos(r, angle);
            paintMinuteDot(r, g2d, pos[0], pos[1], i % 5 == 0);
        }
        paintHourPointer(r, g2d);
        paintMinutePointer(r, g2d);
        paintSecondPointer(r, g2d);
        paintCenterPoint(g2d);
        g2d.scale(1, -1);
        g2d.translate(-insets.left - r * (1 + s), -insets.top - r * (1 + s));
    }

    private void paintCenterPoint(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        Rectangle2D rect = new Rectangle2D.Double(-2, -2, 4, 4);
        g2d.fill(rect);
    }

    private void paintMinutePointer(int r, Graphics2D g2d) {
        int minute = currentTime.get(Calendar.MINUTE);
        int second = currentTime.get(Calendar.SECOND);
        double angle = 90 - (minute + second / 60.0) * 6;
        Shape pointerShape = createPointerShape(r * 0.8, r * 0.04, r * 0.08,
                angle);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(pointerShape);
        g2d.setColor(Color.DARK_GRAY);
        g2d.draw(pointerShape);
    }

    private void paintHourPointer(int r, Graphics2D g2d) {
        int hour = currentTime.get(Calendar.HOUR);
        int minute = currentTime.get(Calendar.MINUTE);
        int second = currentTime.get(Calendar.SECOND);
        double angle = 90 - (hour + minute / 60.0 + second / 3600.0) * 30;
        Shape pointerShape = createPointerShape(r * 0.6, r * 0.06, r * 0.1,
                angle);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(pointerShape);
        g2d.setColor(Color.DARK_GRAY);
        g2d.draw(pointerShape);
    }

    private Shape createPointerShape(double r1, double r2, double r3,
            double angle) {
        GeneralPath gp = new GeneralPath();
        double[] pos = calcPos(r1, angle);
        double[] pos1 = calcPos(r2, angle + 90);
        gp.append(new Line2D.Double(pos[0], pos[1], pos1[0], pos1[1]), true);
        double[] pos2 = calcPos(r3, angle + 180);
        gp.lineTo((float) pos2[0], (float) pos2[1]);
        double[] pos3 = calcPos(r2, angle + 270);
        gp.lineTo((float) pos3[0], (float) pos3[1]);
        gp.closePath();
        return gp;
    }

    private void paintSecondPointer(int r, Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        int second = currentTime.get(Calendar.SECOND);
        int angle = 90 - second * 6;
        double pos[] = calcPos(r * 0.9, angle);
        double pos1[] = calcPos(r * 0.2, angle + 180);
        Line2D line = new Line2D.Double(pos1[0], pos1[1], pos[0], pos[1]);
        g2d.draw(line);
    }

    private void paintMinuteDot(int r, Graphics2D g2d, double x, double y,
            boolean flag) {
        g2d.setColor(flag ? Color.RED : Color.BLACK);
        if (flag) {
            // Rectangle2D rect = new Rectangle2D.Double(
            Ellipse2D rect = new Ellipse2D.Double(x - r * s, y - r * s, r * s
                    * 2, r * s * 2);
            g2d.fill(rect);
        } else {
            // Rectangle2D rect = new Rectangle2D.Double(
            Ellipse2D rect = new Ellipse2D.Double(x - r * 0.02, y - r * 0.02,
                    r * 0.04, r * 0.04);
            g2d.fill(rect);
        }
    }

    private double[] calcPos(double r, double angle) {
        double radian = Math.toRadians(angle);
        double x = r * Math.cos(radian);
        double y = r * Math.sin(radian);

        return new double[]{x, y};
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        final Clock clock = new Clock(50);
        clock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JFrame f = new JFrame("GDI+ʱ��");
        // f.setBounds(380,200,500,600);
        f.add(clock, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        new Thread() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    clock.setCurrentTime(System.currentTimeMillis());
                    clock.repaint();
                }
            }
        }.start();
    }
}
