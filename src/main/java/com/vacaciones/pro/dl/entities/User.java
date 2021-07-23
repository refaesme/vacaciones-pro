// Generated with g9.

package com.vacaciones.pro.dl.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="users")
public class User implements Serializable {

    /** Primary key. */
    protected static final String PK = "userId";

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", unique=true, nullable=false, precision=10)
    private Long userId;
    
    @Column(name="user_name", nullable=false, length=200)
    private String userName;
    
    @Column(name="user_pass", nullable=false, length=200)
    private String userPass;
    
    @Column(name="user_state", nullable=false, length=3)
    private boolean userState;
    
    @Column(name="rol_id", nullable=false, precision=10)
    private Long rolId;
    
    @ManyToOne
    @JoinColumn(name="collaborator_id")
    private Collaborator collaborator;
    
    @OneToMany(mappedBy="user")
    private Set<Rol> rol;

    /** Default constructor. */
    public User() {
        super();
    }

    /**
     * Access method for userId.
     *
     * @return the current value of userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Setter method for userId.
     *
     * @param aUserId the new value for userId
     */
    public void setUserId(Long aUserId) {
        userId = aUserId;
    }

    /**
     * Access method for userName.
     *
     * @return the current value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for userName.
     *
     * @param aUserName the new value for userName
     */
    public void setUserName(String aUserName) {
        userName = aUserName;
    }

    /**
     * Access method for userPass.
     *
     * @return the current value of userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * Setter method for userPass.
     *
     * @param aUserPass the new value for userPass
     */
    public void setUserPass(String aUserPass) {
        userPass = aUserPass;
    }

    /**
     * Access method for userState.
     *
     * @return true if and only if userState is currently true
     */
    public boolean getUserState() {
        return userState;
    }

    /**
     * Setter method for userState.
     *
     * @param aUserState the new value for userState
     */
    public void setUserState(boolean aUserState) {
        userState = aUserState;
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
     * Access method for rol.
     *
     * @return the current value of rol
     */
    public Set<Rol> getRol() {
        return rol;
    }

    /**
     * Setter method for rol.
     *
     * @param aRol the new value for rol
     */
    public void setRol(Set<Rol> aRol) {
        rol = aRol;
    }

    /**
     * Compares the key for this instance with another User.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class User and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        Object myUserId = this.getUserId();
        Object yourUserId = that.getUserId();
        if (myUserId==null ? yourUserId!=null : !myUserId.equals(yourUserId)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another User.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return this.equalKeys(other) && ((User)other).equalKeys(this);
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
        if (getUserId() == null) {
            i = 0;
        } else {
            i = getUserId().hashCode();
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
        StringBuffer sb = new StringBuffer("[User |");
        sb.append(" userId=").append(getUserId());
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
        ret.put("userId", getUserId());
        return ret;
    }

}
