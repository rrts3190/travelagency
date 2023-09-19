package edu.wgu.d288_backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vacation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id", nullable = false)
    private long vacationId;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private LocalDateTime   lastUpdate;

    @Column(name = "description")
    private String description;

    @Column(name = "vacation_title")
    private String vacationTitle;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "travel_fare_price", precision = 19, scale = 2)
    private double farePrice;

    @OneToMany(mappedBy ="excursionsForeign")
    @JsonManagedReference(value="excursion-movement")
    private Set<Excursion> excursions;

    @OneToMany(mappedBy ="vacationForeign")
    @JsonManagedReference(value="vacation-movement")
    private Set<CartItems> cartItems;

}
