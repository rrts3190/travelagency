package edu.wgu.d288_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.wgu.d288_backend.exception.ValidEnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carts
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Id", nullable = false)
    private long cartId;

    @Column(name = "party_size")
    @Max(value = 4, message = "The partySize should be less than 9999")
    private int partySize;

    @Column(name = "order_tracking_number")
    @Pattern(regexp="^[a-zA-Z0-9 ]+$",message = "The order tracking number should contain only alphanumeric value")
    private String orderTrackNum;

    @Column(name = "package_price", precision = 19, scale = 2)
    @DecimalMin(value = "0.1", message = "Please Enter valid package price(package price > 0)")
    private double pkgPrice;

    @Enumerated(EnumType.STRING)
    @ValidEnumValue(enumClass = StatusType.class, message = "Invalid statusType value")
    @Column(name = "status")
    private StatusType status;


    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private LocalDateTime   lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    @JsonBackReference(value="cart-movement")
    private Customer cartsForeign;

    @OneToMany(mappedBy ="cartItemsForeign")
    @JsonManagedReference(value="cartItem-movement")
    private Set<CartItems> cartItemsSet;
}
