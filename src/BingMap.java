import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class BingMap extends JPanel {

    /**
     * Constructor
     */
    public BingMap() {
        setLayout(new GridLayout(1,1));
        try {
            ImageIcon imageIcon = getMap();
            imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            add(new JLabel (imageIcon));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the map from Bing Maps
     * @return The map
     */
    private ImageIcon getMap() throws Exception {
        String location = "40.714728,-73.998672";
        String BING_MAP_KEY = System.getenv("BING_MAP_KEY");
        String mapURL = "https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/"
                + location + "?zoomLevel=10&mapSize=200,200&key=" + BING_MAP_KEY;

        URL mapImageUrl = new URL(mapURL);
        URLConnection conn = mapImageUrl.openConnection();
        InputStream inputStream = conn.getInputStream();

        OutputStream outputStream = new FileOutputStream("image.jpg");
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, length);
        }

        inputStream.close();
        outputStream.close();

        return new ImageIcon("image.jpg");
    }

    /**
     * Main method for testing
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        JFrame test = new JFrame("Bing Maps");
        test.setLayout(new GridLayout(1,1));
        test.add(new BingMap());
        test.setSize(200,200);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
