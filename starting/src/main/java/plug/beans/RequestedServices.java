/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plug.beans;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aurora
 */
@Entity
@Table(name = "requested_services", catalog = "database1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestedServices.findAll", query = "SELECT r FROM RequestedServices r"),
    @NamedQuery(name = "RequestedServices.findById", query = "SELECT r FROM RequestedServices r WHERE r.id = :id"),
    @NamedQuery(name = "RequestedServices.findByUserId", query = "SELECT r FROM RequestedServices r WHERE r.userId = :userId"),
    @NamedQuery(name = "RequestedServices.findByTitle", query = "SELECT r FROM RequestedServices r WHERE r.title = :title"),
    @NamedQuery(name = "RequestedServices.findByTag", query = "SELECT r FROM RequestedServices r WHERE r.tag = :tag"),
    @NamedQuery(name = "RequestedServices.findByBeginDate", query = "SELECT r FROM RequestedServices r WHERE r.beginDate = :beginDate"),
    @NamedQuery(name = "RequestedServices.findByEndDate", query = "SELECT r FROM RequestedServices r WHERE r.endDate = :endDate"),
    @NamedQuery(name = "RequestedServices.findByEnabled", query = "SELECT r FROM RequestedServices r WHERE r.enabled = :enabled"),
    @NamedQuery(name = "RequestedServices.findByServiceEveryone", query = "SELECT r FROM RequestedServices r WHERE r.serviceEveryone = :serviceEveryone")})
public class RequestedServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "desc")
    private String desc;
    @Basic(optional = false)
    @Column(name = "tag")
    private String tag;
    @Basic(optional = false)
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @Column(name = "service_everyone")
    private boolean serviceEveryone;

    public RequestedServices() {
    }

    public RequestedServices(Integer id) {
        this.id = id;
    }

    public RequestedServices(Integer id, int userId, String title, String desc, String tag, Date beginDate, Date endDate, boolean enabled, boolean serviceEveryone) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.desc = desc;
        this.tag = tag;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.enabled = enabled;
        this.serviceEveryone = serviceEveryone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getServiceEveryone() {
        return serviceEveryone;
    }

    public void setServiceEveryone(boolean serviceEveryone) {
        this.serviceEveryone = serviceEveryone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestedServices)) {
            return false;
        }
        RequestedServices other = (RequestedServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.RequestedServices[ id=" + id + " ]";
    }
    
}