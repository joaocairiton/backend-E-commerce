package com.cairiton.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user")
public class User implements UserDetails{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String username;
	
	@NotBlank
	@Size(max = 60)
	private String password;
	
	@NotBlank
	@Size(max = 60)
	private String name;
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	@NotBlank
	@Size(max = 20)
	private String telefone;
	private boolean enable = true;
	private String perfil;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRol> userRoles = new HashSet<>();
	
	 public User(){

	 }

	public User(Long id, @NotBlank @Size(max = 60) String username, @NotBlank @Size(max = 60) String password,
			@NotBlank @Size(max = 60) String name, @NotBlank @Email @Size(max = 255) String email,
			@NotBlank @Size(max = 20) String telefone, boolean enable, String perfil) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.enable = enable;
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<UserRol> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRol> userRoles) {
		this.userRoles = userRoles;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 Set<Authority> authorities = new HashSet<>();
		 
		 this.userRoles.forEach(userRol -> {
			 authorities.add(new Authority(userRol.getRol().getRolName()));
	        });
	        return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;
	}
	
	
	 
	 
	 
	 
    
	
	
	

	

}
