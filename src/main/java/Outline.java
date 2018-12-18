import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Outline implements Transform {
    private final int threshold;

    public Outline(int threshold) {
        this.threshold = threshold;
    }


    private List<GrayColor> getSouthEastNeighborPixels(GrayImage image, int x, int y){
        List<GrayColor> neighborPixels = new ArrayList<GrayColor>();
        if (x != image.getWidth()-1) {
            neighborPixels.add(image.getPixelGrayColor(x+1, y));
        }
        if (y != image.getHeight()-1) {
            neighborPixels.add(image.getPixelGrayColor(x, y+1));
        }
        return neighborPixels;
    }

    @Override
    public void applyTo(GrayImage image) {
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                modifyPixel(image, x, y);
            }
        }
    }

    private void modifyPixel(GrayImage image, int x, int y) {
        GrayColor pixel = image.getPixelGrayColor(x,y);
        List<GrayColor> neighboorPixels = getSouthEastNeighborPixels(image,x,y);
        int newGrayLevel = ByteGrayColor.MAXIMUM_GRAY_LEVEL;

        for(GrayColor neighboorPixel : neighboorPixels){
            if(Math.abs(neighboorPixel.compareTo(image.getPixelGrayColor(x,y))) > threshold) {
                newGrayLevel = ByteGrayColor.MINIMUM_GRAY_LEVEL;
            }
        }
        image.setGrayLevel(newGrayLevel, x, y);
    }

}
