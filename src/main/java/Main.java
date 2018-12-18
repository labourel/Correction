


public class Main
{

    public static void main(String[] args) {
        MatrixGrayImage image = MatrixGrayImage.createImageFromPGMFile("images/luminy.pgm");
        // rajouter les transformations sur image
        image.writeIntoPGMFormat("/Users/arnaud/luminy.pgm");
    }

}
