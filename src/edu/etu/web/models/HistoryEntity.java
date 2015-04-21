package edu.etu.web.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by korkota on 4/20/15.
 */
@Entity
@Table(name = "history", schema = "public", catalog = "test_database")
public class HistoryEntity {
    private String userId;
    private int itemId;
    private Integer marketId;
    private String deliveryAddress;
    private int itemCount;
    private Date date;
    private Integer id;

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "market_id")
    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    @Basic
    @Column(name = "delivery_address")
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Basic
    @Column(name = "item_count")
    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @Column(name = "id")
    @SequenceGenerator(name="pk_sequence",sequenceName="history_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryEntity that = (HistoryEntity) o;
        if (itemCount != that.itemCount) return false;

        if (id != that.id) return false;
        if (itemId != that.itemId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null)
            return false;
        if (marketId != null ? !marketId.equals(that.marketId) : that.marketId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + itemId;
        result = 31 * result + (marketId != null ? marketId.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        result = 31 * result + itemCount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
