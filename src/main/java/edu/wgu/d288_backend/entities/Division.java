package edu.wgu.d288_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Divisions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class Division
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_Id", nullable = false)
    private long divisionId;

    @Column(name = "division")
    @Pattern(regexp="^[A-Za-z ]*$",message = "The division should contain only alphabetic characters")
    private String division;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private LocalDateTime   lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id")
   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference(value="country-movement")
    private Country countryForeign;

    @OneToMany(mappedBy ="customersForeign")
    @JsonManagedReference(value="customer-movement")
    private Set<Customer> customers;
}
