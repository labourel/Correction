import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */
public class MatrixGrayImage implements GrayImage {
    private GrayColor[][] pixels;
    private final int width;
    private final int height;

    @Override
    public int getMaximumGrayLevel(int x, int y) {
        return pixels[x][y].getMaximumGrayLevel();
    }

    @Override
    public GrayColor getPixelGrayColor(int x, int y) {
        return pixels[x][y];
    }

    @Override
    public void setGrayLevel(int graylevel, int x, int y) {
        pixels[x][y].setGrayLevel(graylevel);
    }

    @Override
    public int getGraylevel(int x, int y) {
        return pixels[x][y].getGrayLevel();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y].getColor();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public MatrixGrayImage(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new ByteGrayColor[width][height];

        for(int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                pixels[x][y] = new ByteGrayColor();
            }
        }
    }


    public static MatrixGrayImage createImageFromPGMFile(String fileName) {
        InputStream file = ClassLoader.getSystemResourceAsStream(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        scan.nextLine();
        scan.nextLine();

        int width = scan.nextInt();
        int height = scan.nextInt();

        MatrixGrayImage result = new MatrixGrayImage(width, height);

        scan.nextInt();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++) {
                result.pixels[x][y] = new ByteGrayColor(scan.nextInt());
            }
        }

        return result;
    }

    public void writeIntoPGMFormat(String fileName){

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("P2");
            printWriter.println("# CREATOR: TP3 Version 1.0");
            printWriter.printf("%d %d\n",this.width, this.height);

            printWriter.println(ByteGrayColor.MAXIMUM_GRAY_LEVEL);

            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++) {
                    printWriter.println(getGraylevel(x,y));
                }
            }
            printWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
