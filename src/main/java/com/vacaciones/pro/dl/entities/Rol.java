// Generated with g9.

package com.vacaciones.pro.dl.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="roles")
@IdClass(Rol.RolId.class)
public class Rol implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class RolId implements Serializable {
        java.lang.Long rolId;
    }

    /** Primary key. */
    protected static final String PK = "RolPrimary";

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
    @Column(name="rol_id", nullable=false, precision=10)
    private Long rolId;
    @Column(name="rol_name", nullable=false, length=45)
    private String rolName;
    @ManyToOne(optional=false)
    @JoinColumn(name="users_user_id", nullable=false)
    private User user;

    /** Default constructor. */
    public Rol() {
        super();
    }

    /**
     * Access method for rolId.
     *
     * @return the current value of rolId
     */
    public Long getRolId() {
        return rolId;
    }

    /**
     * Setter method for rolId.
     *
     * @param aRolId the new value for rolId
     */
    public void setRolId(Long aRolId) {
        rolId = aRolId;
    }

    /**
     * Access method for rolName.
     *
     * @return the current value of rolName
     */
    public String getRolName() {
        return rolName;
    }

    /**
     * Setter method for rolName.
     *
     * @param aRolName the new value for rolName
     */
    public void setRolName(String aRolName) {
        rolName = aRolName;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(User aUser) {
        user = aUser;
    }

    /**
     * Compares the key for this instance with another Rol.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Rol and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Rol)) {
            return false;
        }
        Rol that = (Rol) other;
        Object myRolId = this.getRolId();
        Object yourRolId = that.getRolId();
        if (myRolId==null ? yourRolId!=null : !myRolId.equals(yourRolId)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Rol.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rol)) return false;
        return this.equalKeys(other) && ((Rol)other).equalKeys(this);
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
        if (getRolId() == null) {
            i = 0;
        } else {
            i = getRolId().hashCode();
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
        StringBuffer sb = new StringBuffer("[Rol |");
        sb.append(" rolId=").append(getRolId());
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
        ret.put("rolId", getRolId());
        return ret;
    }

}
