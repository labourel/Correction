import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */

public class ByteGrayColor implements GrayColor {
    private int grayLevel;
    public static final int MAXIMUM_GRAY_LEVEL = 255;
    public static final int MINIMUM_GRAY_LEVEL = 0;
    private static final int OPACITY = 1;

    public int getGrayLevel() {
        return grayLevel;
    }

    public ByteGrayColor(){
        this(MINIMUM_GRAY_LEVEL);
    }

    public ByteGrayColor(int grayLevel) {
        this.grayLevel = grayLevel;
    }

    @Override
    public Color getColor(){
        return new Color(grayLevel/(double) MAXIMUM_GRAY_LEVEL,
                grayLevel/(double) MAXIMUM_GRAY_LEVEL,
                grayLevel/(double) MAXIMUM_GRAY_LEVEL,
                OPACITY);
    }

    @Override
    public void setGrayLevel(int grayLevel) {
        this.grayLevel = grayLevel;
    }

    @Override
    public int compareTo(GrayColor o) {
        return this.getGrayLevel() - o.getGrayLevel();
    }

    @Override
    public int getMaximumGrayLevel() {
        return MAXIMUM_GRAY_LEVEL;
    }
}
