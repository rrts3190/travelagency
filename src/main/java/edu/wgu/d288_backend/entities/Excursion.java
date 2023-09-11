package edu.wgu.d288_backend.entities;


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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false)
    private long excursionId;

    @CreationTimestamp
    @Column(name = "create_date")
    private Instant createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Column(name = "excursion_price", precision = 19, scale = 2)
    @Type(type = "big_decimal")
    private double excursionPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "excursion_title")
    private String excursionTitle;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation excursionsForeign;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItems> excursions;

}
