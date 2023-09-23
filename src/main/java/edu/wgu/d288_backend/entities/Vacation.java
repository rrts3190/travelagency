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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp="^[.a-zA-Z0-9 ]+$",message = "The description should contain only alphanumeric value")
    private String description;

    @Column(name = "vacation_title")
    @Pattern(regexp="^[A-Za-z ]*$",message = "The vacation title should contain only alphabetic characters")
    private String vacationTitle;

    @Column(name = "image_url")
    @Pattern(regexp= "((http|https)://)(www.)?[a-zA-Z0-9@:%._+~#?&/=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._+~#?&/=]*)",
            message = "Please pass valid image url")
    private String imageUrl;

    @Column(name = "travel_fare_price", precision = 19, scale = 2)
    @DecimalMin(value = "0.1", message = "Please Enter valid fare price(fare price > 0)")
    private double farePrice;

    @OneToMany(mappedBy ="excursionsForeign")
    @JsonManagedReference(value="excursion-movement")
    private Set<Excursion> excursions;

    @OneToMany(mappedBy ="vacationForeign")
    @JsonManagedReference(value="vacation-movement")
    private Set<CartItems> cartItems;

}
