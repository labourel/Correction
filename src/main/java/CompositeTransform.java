/**
 * Created by Arnaud Labourel on 04/10/2018.
 */

public class CompositeTransform implements Transform {
    private Transform[] transforms;

    public CompositeTransform(Transform[] transforms) {
        this.transforms = transforms;
    }

    @Override
    public void applyTo(GrayImage image) {
        for(Transform transform : transforms){
            transform.applyTo(image);
        }
    }
}
