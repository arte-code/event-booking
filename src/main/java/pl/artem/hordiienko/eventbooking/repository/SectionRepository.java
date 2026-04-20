package pl.artem.hordiienko.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.artem.hordiienko.eventbooking.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
