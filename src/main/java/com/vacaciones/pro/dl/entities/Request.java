// Generated with g9.

package com.vacaciones.pro.dl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name="requests")
public class Request implements Serializable {

   
    /** Primary key. */
    protected static final String PK = "RequestPrimary";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id", unique=true, nullable=false, precision=10)
    private Long requestId;
    
    @Column(name="request_status", nullable=false, length=45)
    private String requestStatus;
    
    @Temporal(TemporalType.DATE)
    @Column(name="request_created_at", nullable=false)
    private Date requestCreatedAt;
    
    @Column(name="collaborator_id", nullable=false, precision=10)
    private Long collaboratorId;
    
    @Temporal(TemporalType.DATE)
    @Column(name="request_begin_day", nullable=false)
    private Date requestBeginDay;
    
    @Temporal(TemporalType.DATE)
    @Column(name="request_end_day", nullable=false)
    private Date requestEndDay;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="collaborators_collaborator_id", nullable=false)
    private Collaborator collaborator;

    /** Default constructor. */
    public Request() {
        super();
    }

    /**
     * Access method for requestId.
     *
     * @return the current value of requestId
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     * Setter method for requestId.
     *
     * @param aRequestId the new value for requestId
     */
    public void setRequestId(Long aRequestId) {
        requestId = aRequestId;
    }

    /**
     * Access method for requestStatus.
     *
     * @return the current value of requestStatus
     */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * Setter method for requestStatus.
     *
     * @param aRequestStatus the new value for requestStatus
     */
    public void setRequestStatus(String aRequestStatus) {
        requestStatus = aRequestStatus;
    }

    /**
     * Access method for requestCreatedAt.
     *
     * @return the current value of requestCreatedAt
     */
    public Date getRequestCreatedAt() {
        return requestCreatedAt;
    }

    /**
     * Setter method for requestCreatedAt.
     *
     * @param aRequestCreatedAt the new value for requestCreatedAt
     */
    public void setRequestCreatedAt(Date aRequestCreatedAt) {
        requestCreatedAt = aRequestCreatedAt;
    }

    /**
     * Access method for collaboratorId.
     *
     * @return the current value of collaboratorId
     */
    public Long getCollaboratorId() {
        return collaboratorId;
    }

    /**
     * Setter method for collaboratorId.
     *
     * @param aCollaboratorId the new value for collaboratorId
     */
    public void setCollaboratorId(Long aCollaboratorId) {
        collaboratorId = aCollaboratorId;
    }

    /**
     * Access method for requestBeginDay.
     *
     * @return the current value of requestBeginDay
     */
    public Date getRequestBeginDay() {
        return requestBeginDay;
    }

    /**
     * Setter method for requestBeginDay.
     *
     * @param aRequestBeginDay the new value for requestBeginDay
     */
    public void setRequestBeginDay(Date aRequestBeginDay) {
        requestBeginDay = aRequestBeginDay;
    }

    /**
     * Access method for requestEndDay.
     *
     * @return the current value of requestEndDay
     */
    public Date getRequestEndDay() {
        return requestEndDay;
    }

    /**
     * Setter method for requestEndDay.
     *
     * @param aRequestEndDay the new value for requestEndDay
     */
    public void setRequestEndDay(Date aRequestEndDay) {
        requestEndDay = aRequestEndDay;
    }

    /**
     * Access method for collaborator.
     *
     * @return the current value of collaborator
     */
    public Collaborator getCollaborator() {
        return collaborator;
    }

    /**
     * Setter method for collaborator.
     *
     * @param aCollaborator the new value for collaborator
     */
    public void setCollaborator(Collaborator aCollaborator) {
        collaborator = aCollaborator;
    }

    /**
     * Compares the key for this instance with another Request.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Request and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Request)) {
            return false;
        }
        Request that = (Request) other;
        Object myRequestId = this.getRequestId();
        Object yourRequestId = that.getRequestId();
        if (myRequestId==null ? yourRequestId!=null : !myRequestId.equals(yourRequestId)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Request.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Request)) return false;
        return this.equalKeys(other) && ((Request)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        if (getRequestId() == null) {
            i = 0;
        } else {
            i = getRequestId().hashCode();
        }
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Request |");
        sb.append(" requestId=").append(getRequestId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("requestId", getRequestId());
        return ret;
    }

}
