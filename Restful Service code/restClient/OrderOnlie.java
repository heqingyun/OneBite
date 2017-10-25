/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restClient;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author qingyunhe
 */
@Entity
@Table(name = "ORDER_ONLIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderOnlie.findAll", query = "SELECT o FROM OrderOnlie o")
    , @NamedQuery(name = "OrderOnlie.findByOrderId", query = "SELECT o FROM OrderOnlie o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderOnlie.findBySellerId", query = "SELECT o FROM OrderOnlie o WHERE o.sellerId = :sellerId")
    , @NamedQuery(name = "OrderOnlie.findByNumber", query = "SELECT o FROM OrderOnlie o WHERE o.number = :number")})
public class OrderOnlie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "SELLER_ID")
    private Integer sellerId;
    @Column(name = "NUMBER")
    private Integer number;
    @JoinColumn(name = "FOOD_ID", referencedColumnName = "FOOD_ID")
    @ManyToOne
    private Food foodId;
    @JoinColumn(name = "BUYER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserInfo buyerId;

    public OrderOnlie() {
    }

    public OrderOnlie(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }

    public UserInfo getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(UserInfo buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderOnlie)) {
            return false;
        }
        OrderOnlie other = (OrderOnlie) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restClient.OrderOnlie[ orderId=" + orderId + " ]";
    }
    
}
