package pl.artem.hordiienko.eventbooking.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SeatType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SeatStatus status;


    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime created_at;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updated_at;
}
