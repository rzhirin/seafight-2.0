import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Table(appliesTo = "ship_pixes")
public class ShipPixel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer posX;
    @Column
    private Integer posY;

    public Integer getId() {
        return id;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public ShipPixel() {
    }

    public ShipPixel(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public boolean isHits(ShipPixel p) {
        return (this.getPosX() == p.getPosX()
                && this.getPosY() == p.getPosY());
    }

    public boolean isHits(List<ShipPixel> hits) {
        for (ShipPixel hit : hits) {
            if (this.isHits(hit)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInField() {
        return (this.getPosX() >= 0 && this.getPosX() < 10
                && this.getPosY() >= 0 && this.getPosY() < 10);
    }
}
