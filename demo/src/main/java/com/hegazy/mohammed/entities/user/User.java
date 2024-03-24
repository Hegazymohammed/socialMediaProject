package com.hegazy.mohammed.entities.user;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.hegazy.mohammed.entities.audit.Audoting;
import com.hegazy.mohammed.entities.group.Group;
import com.hegazy.mohammed.entities.group.GroupMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "user")
@Builder
public class User extends Audoting {


	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	@Column(unique = true)
	private String email;
	private String username;
	private String passwordHash;

	private String intro;
	private String profile;
	
	public User(String firstName, String middleName, String lastName, String mobile, String email, String username,
			String passwordHash, String intro, String profile
			 ) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.passwordHash = passwordHash;

		this.intro = intro;
		this.profile = profile;
		 
	 
	}
	public User(int id,String firstName, String middleName, String lastName, String mobile, String email, String username,
				String passwordHash, String intro, String profile
	) {

		 this(firstName, middleName, lastName, mobile, email, username, passwordHash, intro, profile);
		 this.id=id;

	}
	

	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<UserPost> posts;
	
	@OneToMany(mappedBy ="targetId",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<UserMessage> messages;
	
	@OneToMany(mappedBy = "targetId")
	@ToString.Exclude
	private List<UserFriend>friends;
	
	@OneToMany(mappedBy="targetId")
	@ToString.Exclude
	private List<UserFollower>follwers;
	
 	@OneToMany(mappedBy="createdBy",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
 	@ToString.Exclude
 	private List<Group>groups;
 	
	@OneToMany(mappedBy="userId",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
	@ToString.Exclude
	private List<GroupMessage>groupsMessages;
 
	@OneToMany(mappedBy="userId",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
	@ToString.Exclude
	private List<GroupMessage>groupPosts;
 

}
