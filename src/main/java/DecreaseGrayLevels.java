/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class DecreaseGrayLevels implements Transform {

    private final int nbGrayLevels;

    public DecreaseGrayLevels(int nbGrayLevels) {
        this.nbGrayLevels = nbGrayLevels;
    }

    @Override
    public void applyTo(GrayImage image) {
        for(int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                modifyPixel(image, x, y);
            }
        }
    }

    private void modifyPixel(GrayImage image, int x, int y) {
        int factor = image.getMaximumGrayLevel(x,y) / nbGrayLevels;
        int grayLevel = image.getGraylevel(x, y);
        int newGrayLevel = grayLevel - grayLevel%factor;
        image.setGrayLevel(newGrayLevel, x, y);
    }
}
