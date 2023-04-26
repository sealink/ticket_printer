package au.com.sealink.printing.utils;

import au.com.sealink.printing.ticketprinter.TicketElement;
import au.com.sealink.printing.ticketprinter.printables.PrintableElement;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;

public class ImageLoader {
    public static BufferedImage loadImage(TicketElement element) {
        BufferedImage img = null;
        try {
            if (element.isImageBase64()) {
                String imgEncodedInBase64 = element.getImageValue();
                img = loadImgFromBase64(imgEncodedInBase64);
            } else {
                img = loadImageFromUrl(element.getImageValue());
            }
        } catch (IOException ex) {
            Logger logger = Logger.getLogger(PrintableElement.class.getName());
            logger.log(Level.SEVERE, "Could not load image:\n" + element.getImageValue(), ex);
        }
        return img;
    }

    private static BufferedImage loadImageFromUrl(String imageUrlString) throws IOException {
        URL url = new URL(imageUrlString);
        return ImageIO.read(url);
    }

    private static BufferedImage loadImgFromBase64(String imgEncodedInBase64) throws IOException {
        byte[] imgData = Base64.decodeBase64(imgEncodedInBase64);
        InputStream in = new ByteArrayInputStream(imgData);
        return ImageIO.read(in);
    }
}
