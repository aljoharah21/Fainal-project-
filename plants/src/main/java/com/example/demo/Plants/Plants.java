package com.example.demo.Plants;


import com.example.demo.Climate.Climate;
import com.example.demo.Seasons.Seasons;
import com.example.demo.Type.Type;
import com.example.demo.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name ="plants")
public class Plants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "climate_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Climate climate;

    @ManyToOne
    @JoinColumn(name = "seasons_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Seasons seasons;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Plants() {
    }
    public Plants(Long id, String name, String img, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public Seasons getSeasons() {
        return seasons;
    }

    public void setSeasons(Seasons seasons) {
        this.seasons = seasons;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Plants{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

