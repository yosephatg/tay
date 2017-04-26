package tay.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by yoseph on 4/22/17.
 */

@Entity
@Table(name="nutrition")
//@NamedQueries({
//        @NamedQuery(name = "tay.core.Nutrition.findAll",
//        query = "select n from Nutrition n"),
//        @NamedQuery(name = "tay.core.Nutrition.findByType",
//        query = "select n from Nutrition n where n.type like :type")
//})

public class Nutrition {

    @Id
    @Column(name = "id")
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    @NotNull
    @JsonProperty
    @Size(min = 2, max = 64)
    private String type;

    @NotNull
    @JsonProperty
    @Column(name = "calories")
    private int calories = 0;

    @Column(name = "protein")
    @JsonProperty
    private int protein = 0;

    @Column(name = "fiber")
    @JsonProperty
    private int fiber = 0;

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
