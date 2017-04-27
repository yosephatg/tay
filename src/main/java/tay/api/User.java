package tay.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yoseph on 4/24/17.
 */

@Entity
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Principal, Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username")
    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    @Column(name="name")
    private String name;

//    @NotNull
    @Size(min = 5, max = 20)
    @Column(name="password")
    private String password;

    @Column(name = "created_at", insertable = false, nullable = false, updatable = false)
    private Date createdAt;

    // this should not be in the DB!
    @Transient
    private String token;

    @Column(name="cellNumber")
    @NotNull
    @Size(min = 10, max = 10)
    private String cellNumber;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Nutrition> allNutrition = new ArrayList<>();

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Transient
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User(");
        sb.append("id= ").append(id);
        sb.append(", username= ").append(username).append('\'');
        sb.append(')');
        return sb.toString();
    }

    // yoseph to refactor this later
//    public List<Nutrition> getAllNutrition() {
//        return allNutrition;
//    }

//    public void setAllNutrition(List<Nutrition> allNutrition) {
//        this.allNutrition = allNutrition;
//    }
}