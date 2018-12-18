import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public interface GrayImage extends Image{
    void setGrayLevel(int graylevel, int x, int y);
    int getGraylevel(int x, int y);
    GrayColor getPixelGrayColor(int x, int y);
    int getMaximumGrayLevel(int x, int y);
}
