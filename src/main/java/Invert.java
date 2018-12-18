/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Invert implements Transform{
    @Override
    public void applyTo(GrayImage image) {
        for(int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                modifyPixel(image, x, y);
            }
        }
    }

    private void modifyPixel(GrayImage image, int x, int y) {
        int newGrayLevel = image.getMaximumGrayLevel(x, y) - image.getGraylevel(x,y);
        image.setGrayLevel(newGrayLevel,x,y);
    }
}
