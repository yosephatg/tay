package tay.api;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yoseph on 4/25/17.
 */

@Entity
@Table(name = "auth_tokens")
public class AuthToken implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at", insertable = false, nullable = false, updatable = false)
    private Date createdAt;

    @Column(name="token")
    private String token;

    @ManyToOne(optional = false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
