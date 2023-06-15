package com.cairiton.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
    private Long rolId;
    private String rolName;
    
    public Rol(){

    }
    
    
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    private Set<UserRol> userRoles = new HashSet<>();
    
    
    
    
    public Rol(Long rolId, String rolName) {
		this.rolId = rolId;
		this.rolName = rolName;
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public Set<UserRol> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRol> userRoles) {
		this.userRoles = userRoles;
	}

	

}
