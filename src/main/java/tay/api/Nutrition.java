package tay.api;

import javax.persistence.*;

/**
 * Created by yoseph on 4/22/17.
 */

@Entity
@Table(name="nutrition")
@NamedQueries({
        @NamedQuery(name = "tay.core.Nutrition.findAll",
        query = "select n from Nutrition n"),
        @NamedQuery(name = "tay.core.Nutrition.findByType",
        query = "select n from Nutrition where n.type like :type")
})

public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private int calories;
    private int protein;
    private int fiber;

    public Nutrition() {
    }

    public Nutrition(String type, int calories, int protein, int fiber) {
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.fiber = fiber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }
}
