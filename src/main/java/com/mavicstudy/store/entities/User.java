package com.mavicstudy.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name")
    private String name;
    @Column(  name = "email")
    private String email;
    @Column( name = "password")
    private String password;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @Builder.Default
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address){
        this.addresses.add(address);
        address.setUser(this);
    }

    public  void removeAddress(Address address){
        this.addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    public void addTag(String tagName){
        Tag tag = new Tag(tagName);
        this.getTags().add(tag);
        tag.getUsers().add(this);
    }

    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
    private Profile profile;

}
