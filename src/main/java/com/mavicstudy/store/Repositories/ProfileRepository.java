package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.DTO.UserSummary;
import com.mavicstudy.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query("select p.id as id , p.user.email as email from Profile p where p.loyaltyPoint > ?1 order by p.user.email")
    @EntityGraph(attributePaths = "user")
    List<UserSummary> findLoyalProfiles(int  loyaltyPoint);
}
