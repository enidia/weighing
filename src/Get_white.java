/*import java.awt.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.image.RGBImageFilter;
import java.awt.image.ImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
public class Get_white {
    public Image makeColorTransparent(Image im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {
            public int markerRGB = color.getRGB() | 0xFF000000;
            @Override
            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };
        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}*/
//去除白底框，但石头有部分不能去除，弃用