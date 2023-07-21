package com.authenticator.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`user`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = -4688179531421717627L;
	
	@Column
	@Id
	@JsonProperty(access = Access.WRITE_ONLY)
	Long id;
	
	@Column
	String username;
	
	@Column
	@JsonProperty(access = Access.WRITE_ONLY)
	String password;
	
	@Column
	String email;
}
