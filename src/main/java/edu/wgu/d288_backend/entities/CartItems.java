package edu.wgu.d288_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItems
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id", nullable = false)
    private long cartItemId;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime  createDate;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private LocalDateTime   lastUpdate;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference(value="cartItem-movement")
    private Carts cartItemsForeign;

    @ManyToOne
    @JsonBackReference(value="vacation-movement")
    @JoinColumn(name = "vacation_id")
    private Vacation vacationForeign;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = { @JoinColumn(name = "cart_item_id") },
            inverseJoinColumns = { @JoinColumn(name = "excursion_id") }
    )
    private Set<Excursion> excursions = new HashSet<>();

    public void addExcursion(Excursion excursion)
    {
        this.excursions.add(excursion);
        excursion.getCartItems().add(this);
    }

    public void removeExcursion(long excursionId) {
        Excursion excursion = this.excursions.stream()
                .filter(t -> t.getExcursionId() == excursionId).findFirst().orElse(null);
        if (excursion != null) {
            this.excursions.remove(excursion);
            excursion.getCartItems().remove(this);
        }
    }
}
