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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Column(name = "party_size", nullable = false)
    private int partySize;

    @Column(name = "order_tracking_number")
    private String orderTrackNum;

    @Column(name = "package_price", precision = 19, scale = 2)
    @Type(type = "big_decimal")
    private double pkgPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;


    @CreationTimestamp
    @Column(name = "create_date")
    private Instant createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer cartsForeign;

    @OneToMany(mappedBy ="cartItemsForeign")
    private Set<CartItems> cartItemsForeign;
}
