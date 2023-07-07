package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Channel extends PanacheEntity{

    private String hash;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users;

    public Channel() {
        this.users = new ArrayList<>();
    }
}
