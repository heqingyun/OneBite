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
@Table(name = "USER_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u")
    , @NamedQuery(name = "UserInfo.findByUserId", query = "SELECT u FROM UserInfo u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserInfo.findByPassword", query = "SELECT u FROM UserInfo u WHERE u.password = :password")
    , @NamedQuery(name = "UserInfo.findByPhone", query = "SELECT u FROM UserInfo u WHERE u.phone = :phone")
    , @NamedQuery(name = "UserInfo.findByFavFoodType", query = "SELECT u FROM UserInfo u WHERE u.favFoodType = :favFoodType")
    , @NamedQuery(name = "UserInfo.findByFirstName", query = "SELECT u FROM UserInfo u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "UserInfo.findByLastName", query = "SELECT u FROM UserInfo u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "UserInfo.findByEmail", query = "SELECT u FROM UserInfo u WHERE u.email = :email")
    , @NamedQuery(name = "UserInfo.findByGender", query = "SELECT u FROM UserInfo u WHERE u.gender = :gender")
    , @NamedQuery(name = "UserInfo.findByDob", query = "SELECT u FROM UserInfo u WHERE u.dob = :dob")})
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE")
    private Integer phone;
    @Size(max = 25)
    @Column(name = "FAV_FOOD_TYPE")
    private String favFoodType;
    @Size(max = 100)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 300)
    @Column(name = "ICON_URL")
    private String icon_url;

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }
    @Size(max = 100)
    @Column(name = "LAST_NAME")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(mappedBy = "buyerId")
    private Collection<OrderOnlie> orderOnlieCollection;

    public UserInfo() {
    }

    public UserInfo(String userId) {
        this.userId = userId;
    }

    public UserInfo(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getFavFoodType() {
        return favFoodType;
    }

    public void setFavFoodType(String favFoodType) {
        this.favFoodType = favFoodType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public Collection<OrderOnlie> getOrderOnlieCollection() {
        return orderOnlieCollection;
    }

    public void setOrderOnlieCollection(Collection<OrderOnlie> orderOnlieCollection) {
        this.orderOnlieCollection = orderOnlieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restClient.UserInfo[ userId=" + userId + " ]";
    }
    
}
