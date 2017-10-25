/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restClient;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author qingyunhe
 */
@Entity
@Table(name = "MERCHANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchant.findAll", query = "SELECT m FROM Merchant m")
    , @NamedQuery(name = "Merchant.findByMerchantId", query = "SELECT m FROM Merchant m WHERE m.merchantId = :merchantId")
    , @NamedQuery(name = "Merchant.findByName", query = "SELECT m FROM Merchant m WHERE m.name = :name")
    , @NamedQuery(name = "Merchant.findByAddress", query = "SELECT m FROM Merchant m WHERE m.address = :address")
    , @NamedQuery(name = "Merchant.findByPhone", query = "SELECT m FROM Merchant m WHERE m.phone = :phone")
    , @NamedQuery(name = "Merchant.findByBussinessHour", query = "SELECT m FROM Merchant m WHERE m.bussinessHour = :bussinessHour")
    , @NamedQuery(name = "Merchant.findByType", query = "SELECT m FROM Merchant m WHERE m.type = :type")
    , @NamedQuery(name = "Merchant.findByLongitude", query = "SELECT m FROM Merchant m WHERE m.longitude = :longitude")
    , @NamedQuery(name = "Merchant.findByLatitude", query = "SELECT m FROM Merchant m WHERE m.latitude = :latitude")})
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MERCHANT_ID")
    private Integer merchantId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 300)
    @Column(name = "PIC_URL")
    private String pic_url;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
    @Column(name = "PHONE")
    private Integer phone;
    @Size(max = 20)
    @Column(name = "BUSSINESS_HOUR")
    private String bussinessHour;
    @Size(max = 50)
    @Column(name = "TYPE")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "LATITUDE")
    private Double latitude;
    @OneToMany(mappedBy = "merchantId")
    private Collection<Food> foodCollection;

    public Merchant() {
    }

    public Merchant(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getBussinessHour() {
        return bussinessHour;
    }

    public void setBussinessHour(String bussinessHour) {
        this.bussinessHour = bussinessHour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @XmlTransient
    public Collection<Food> getFoodCollection() {
        return foodCollection;
    }

    public void setFoodCollection(Collection<Food> foodCollection) {
        this.foodCollection = foodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantId != null ? merchantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merchant)) {
            return false;
        }
        Merchant other = (Merchant) object;
        if ((this.merchantId == null && other.merchantId != null) || (this.merchantId != null && !this.merchantId.equals(other.merchantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restClient.Merchant[ merchantId=" + merchantId + " ]";
    }
    
}
