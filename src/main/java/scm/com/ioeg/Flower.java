package scm.com.ioeg;

import java.io.Serializable;

public class Flower implements Serializable {
    /**
     * <h2>serialVersionUID</h2>
     * <p>
     * serialVersionUID
     * </p>
     */
    private static final long serialVersionUID = 123L;
    private String flowerName;
    private int flowerPrice;

    public Flower() {
    }

    public Flower(String flowerName, int flowerPrice) {
        this.flowerName = flowerName;
        this.flowerPrice = flowerPrice;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(int flowerPrice) {
        this.flowerPrice = flowerPrice;
    }
}
