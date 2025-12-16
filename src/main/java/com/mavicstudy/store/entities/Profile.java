package com.mavicstudy.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "loyalty_point")
    private String loyaltyPoint;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    @ToString.Exclude
    private User user;

}
