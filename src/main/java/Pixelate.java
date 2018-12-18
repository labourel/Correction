/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Pixelate implements Transform{
    final int newPixelSize;

    public Pixelate(int newPixelSize) {
        this.newPixelSize = newPixelSize;
    }

    public void setGrayLevel(int graylevel, GrayImage image, int x, int y, int width, int height){
        for(int i = x; i<Math.min(x + width, image.getWidth()); i++)
            for(int j = y; j<Math.min(y+height, image.getHeight()); j++){
                image.setGrayLevel(graylevel, i, j);
            }
    }

    public int averageGrayLevel(GrayImage image, int x, int y, int width, int height) {
        int sum = 0;
        int nbPixels = 0;
        for (int i = x; i < Math.min(x + width, image.getWidth()); i++)
            for (int j = y; j < Math.min(y + height, image.getHeight()); j++) {
                sum += image.getGraylevel(x,y);
                nbPixels++;
            }
        return sum / nbPixels;
    }


    @Override
    public void applyTo(GrayImage image){
        int rowCount = (int) Math.ceil((double)image.getWidth()/newPixelSize);
        int columnCount = (int) Math.ceil((double)image.getHeight()/newPixelSize);

        int[][] grayLevels = new int[rowCount][columnCount];
        for(int i = 0; i<rowCount; i++)
            for(int j = 0; j<columnCount; j++){
                grayLevels[i][j] = averageGrayLevel(image, i*newPixelSize, j*newPixelSize, newPixelSize, newPixelSize);
                setGrayLevel(grayLevels[i][j], image, i * newPixelSize, j * newPixelSize, newPixelSize, newPixelSize);
            }
    }
}
