/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restClient;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author qingyunhe
 */
@Entity
@Table(name = "FOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
    , @NamedQuery(name = "Food.findByFoodId", query = "SELECT f FROM Food f WHERE f.foodId = :foodId")
    , @NamedQuery(name = "Food.findByName", query = "SELECT f FROM Food f WHERE f.name = :name")
    , @NamedQuery(name = "Food.findByRemainNum", query = "SELECT f FROM Food f WHERE f.remainNum = :remainNum")
    , @NamedQuery(name = "Food.findByDescription", query = "SELECT f FROM Food f WHERE f.description = :description")
    , @NamedQuery(name = "Food.findByPrice", query = "SELECT f FROM Food f WHERE f.price = :price")
    , @NamedQuery(name = "Food.findByEndTime", query = "SELECT f FROM Food f WHERE f.endTime = :endTime")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOOD_ID")
    private Integer foodId;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "REMAIN_NUM")
    private Integer remainNum;
    @Size(max = 225)
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Size(max = 300)
    @Column(name = "PIC_URL")
    private String pic_url;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.DATE)
    private Date endTime;
    @OneToMany(mappedBy = "foodId")
    private Collection<OrderOnlie> orderOnlieCollection;
    @JoinColumn(name = "MERCHANT_ID", referencedColumnName = "MERCHANT_ID")
    @ManyToOne
    private Merchant merchantId;
    
    public Food() {
    }

    public Food(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public Collection<OrderOnlie> getOrderOnlieCollection() {
        return orderOnlieCollection;
    }

    public void setOrderOnlieCollection(Collection<OrderOnlie> orderOnlieCollection) {
        this.orderOnlieCollection = orderOnlieCollection;
    }

    public Merchant getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Merchant merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restClient.Food[ foodId=" + foodId + " ]";
    }
    
}
