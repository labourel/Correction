/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class CrissCross implements Transform{

    private final int size;

    public CrissCross(int size){
        this.size = size;
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
        if(x%size == 0 || y%size ==0){
            image.setGrayLevel(ByteGrayColor.MAXIMUM_GRAY_LEVEL,x,y);
        }
    }
}
