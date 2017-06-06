package entities;

import javax.persistence.*;

/**
 * Created by Ionas on 30.04.2017.
 */
@Entity
@Table(name = "orders", schema = "restaurant", catalog = "")
@NamedQuery(name = "Order.findByClientId", query =
        "SELECT o FROM Order o " +
                "WHERE o.clientByClientId.id = :client_id")
public class Order {
    private int id;
    private Integer dishCount;
    private Byte isAccepted;
    private Byte isPayed;
    private Dish dishByDishId;
    private Client clientByClientId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dish_count", nullable = true)
    public Integer getDishCount() {
        return dishCount;
    }

    public void setDishCount(Integer dishCount) {
        this.dishCount = dishCount;
    }

    @Basic
    @Column(name = "isAccepted", nullable = true)
    public Byte getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Byte isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Basic
    @Column(name = "isPayed", nullable = true)
    public Byte getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Byte isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (id != that.id) return false;
        if (dishCount != null ? !dishCount.equals(that.dishCount) : that.dishCount != null) return false;
        if (isAccepted != null ? !isAccepted.equals(that.isAccepted) : that.isAccepted != null) return false;
        if (isPayed != null ? !isPayed.equals(that.isPayed) : that.isPayed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dishCount != null ? dishCount.hashCode() : 0);
        result = 31 * result + (isAccepted != null ? isAccepted.hashCode() : 0);
        result = 31 * result + (isPayed != null ? isPayed.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id", nullable = false)
    public Dish getDishByDishId() {
        return dishByDishId;
    }

    public void setDishByDishId(Dish dishByDishId) {
        this.dishByDishId = dishByDishId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nDish:\n" + dishByDishId.toString() +
                "\nCount: " + dishCount +
                "\nClient:\n" + clientByClientId.toString() +
                "\nIsAccepted: " + String.valueOf(isAccepted) +
                " IsPayed: " + String.valueOf(isPayed);
    }
}
