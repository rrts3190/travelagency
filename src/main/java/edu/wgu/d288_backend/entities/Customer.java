package edu.wgu.d288_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id", nullable = false)
    private long customerId;

    @Column(name = "customer_first_name")
    @Pattern(regexp="^[A-Za-z ]*$",message = "The first name should contain only alphabetic characters")
    private String firstName;

    @Column(name = "customer_last_name")
    @Pattern(regexp="^[A-Za-z ]*$",message = "The last name should contain only alphabetic characters")
    private String lastName;

    @Column(name = "phone")
    @Pattern(regexp="(^$|[0-9]{10})", message = "The phone number should consist only of numeric characters, and its length should be 10 digits")
    private String phone;

    @Column(name = "postal_code")
    @Pattern(regexp="(^$|[0-9]{6})", message = "The postal code should consist only of numeric characters, and its length should be 6 digits")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private LocalDateTime   lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_Id")
    @JsonBackReference(value="customer-movement")
    private Division customersForeign;

    @OneToMany(mappedBy ="cartsForeign")
    @JsonManagedReference(value="cart-movement")
    private Set<Carts> carts;
}
