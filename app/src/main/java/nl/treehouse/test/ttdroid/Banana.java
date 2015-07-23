package nl.treehouse.test.ttdroid;

/**
 * Created by justinhammenga on 23/07/15.
 * Vacatures.nl B.V.
 */
public class Banana {
    private boolean mIsPeeled = false;

    public Banana() {

    }

    public void peel() {
        mIsPeeled = true;
    }

    public boolean isPeeled() {
        return mIsPeeled;
    }
}
