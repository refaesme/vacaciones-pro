// Generated with g9.

package com.vacaciones.pro.dl.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="collaborators")
public class Collaborator implements Serializable {

    /** Primary key. */
    protected static final String PK = "collaboratorId";

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
    @Column(name="collaborator_id", unique=true, nullable=false, precision=10)
    private Long collaboratorId;
    
    @Column(name="collaborator_name", nullable=false, length=200)
    private String collaboratorName;
    
    @Column(name="collaborator_surname", nullable=false, length=200)
    private String collaboratorSurname;
    
    @Column(name="collaborator_email", nullable=false, length=200)
    private String collaboratorEmail;
    
    @OneToMany(mappedBy="collaborator")
    private Set<User> user;
    
    @OneToMany(mappedBy="collaborator")
    private Set<Request> request;

    /** Default constructor. */
    public Collaborator() {
        super();
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
     * Access method for collaboratorName.
     *
     * @return the current value of collaboratorName
     */
    public String getCollaboratorName() {
        return collaboratorName;
    }

    /**
     * Setter method for collaboratorName.
     *
     * @param aCollaboratorName the new value for collaboratorName
     */
    public void setCollaboratorName(String aCollaboratorName) {
        collaboratorName = aCollaboratorName;
    }

    /**
     * Access method for collaboratorSurname.
     *
     * @return the current value of collaboratorSurname
     */
    public String getCollaboratorSurname() {
        return collaboratorSurname;
    }

    /**
     * Setter method for collaboratorSurname.
     *
     * @param aCollaboratorSurname the new value for collaboratorSurname
     */
    public void setCollaboratorSurname(String aCollaboratorSurname) {
        collaboratorSurname = aCollaboratorSurname;
    }

    /**
     * Access method for collaboratorEmail.
     *
     * @return the current value of collaboratorEmail
     */
    public String getCollaboratorEmail() {
        return collaboratorEmail;
    }

    /**
     * Setter method for collaboratorEmail.
     *
     * @param aCollaboratorEmail the new value for collaboratorEmail
     */
    public void setCollaboratorEmail(String aCollaboratorEmail) {
        collaboratorEmail = aCollaboratorEmail;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public Set<User> getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(Set<User> aUser) {
        user = aUser;
    }

    /**
     * Access method for request.
     *
     * @return the current value of request
     */
    public Set<Request> getRequest() {
        return request;
    }

    /**
     * Setter method for request.
     *
     * @param aRequest the new value for request
     */
    public void setRequest(Set<Request> aRequest) {
        request = aRequest;
    }

    /**
     * Compares the key for this instance with another Collaborator.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Collaborator and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Collaborator)) {
            return false;
        }
        Collaborator that = (Collaborator) other;
        Object myCollaboratorId = this.getCollaboratorId();
        Object yourCollaboratorId = that.getCollaboratorId();
        if (myCollaboratorId==null ? yourCollaboratorId!=null : !myCollaboratorId.equals(yourCollaboratorId)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Collaborator.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Collaborator)) return false;
        return this.equalKeys(other) && ((Collaborator)other).equalKeys(this);
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
        if (getCollaboratorId() == null) {
            i = 0;
        } else {
            i = getCollaboratorId().hashCode();
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
        StringBuffer sb = new StringBuffer("[Collaborator |");
        sb.append(" collaboratorId=").append(getCollaboratorId());
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
        ret.put("collaboratorId", getCollaboratorId());
        return ret;
    }

}
