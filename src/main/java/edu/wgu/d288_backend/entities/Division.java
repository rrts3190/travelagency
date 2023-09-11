package edu.wgu.d288_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class Division
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_Id", nullable = false)
    private long divisionId;

    @Column(name = "division", nullable = false)
    private String division;


    @CreationTimestamp
    @Column(name = "create_date")
    private Instant createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryForeign;

    @OneToMany(mappedBy ="customersForeign")
    private Set<Customer> customers;




}
