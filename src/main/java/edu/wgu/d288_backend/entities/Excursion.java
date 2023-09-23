package edu.wgu.d288_backend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private LocalDateTime   lastUpdate;

    @Column(name = "excursion_price", precision = 19, scale = 2)
    @DecimalMin(value = "0.1", message = "Please Enter valid Excursion price(Excursion price > 0)")
    private double excursionPrice;

    @Column(name = "image_url")
    @Pattern(regexp= "((http|https)://)(www.)?[a-zA-Z0-9@:%._+~#?&/=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._+~#?&/=]*)",
            message = "Please pass valid image url")
    private String imageUrl;

    @Column(name = "excursion_title")
    @Pattern(regexp="^[A-Za-z ]*$",message = "The excursion title should contain only alphabetic characters")
    private String excursionTitle;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    @JsonBackReference(value="excursion-movement")
    private Vacation excursionsForeign;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "excursions")
    @JsonIgnore
    private Set<CartItems> cartItems = new HashSet<>();;

}
