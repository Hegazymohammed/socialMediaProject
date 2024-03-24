package com.hegazy.mohammed.entities.user;

import java.time.LocalDateTime;

import com.hegazy.mohammed.entities.audit.UserAuditing;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="user_follower")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFollower extends UserAuditing {

	@ManyToOne
	@JoinColumn(name="targetId")
	@ToString.Exclude
	private User targetId ;
	
	@ManyToOne
	@JoinColumn(name="sourceId")
	@ToString.Exclude
	private User sourceId;
	
	private int type;

	
	
}
