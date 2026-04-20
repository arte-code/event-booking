package pl.artem.hordiienko.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.artem.hordiienko.eventbooking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
