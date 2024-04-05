package com.candenizgumus.entities;

import com.candenizgumus.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblarac")
@NamedQuery(
        name = "Arac.updateStatusById",
        query = "UPDATE Arac a SET a.status = :newStatus WHERE a.id = :aracId"
)
public class Arac
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marka;
    String model;
    @Enumerated(EnumType.STRING)
    Status status;
}
