package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room")
public class RecoveryRoom extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@Size(min=3,max=50)
    String name;
    
	@Min(0)
	@Positive
    double size;
    
	@NotEmpty
    boolean secure;
    
//    @Transient
	@ManyToOne(optional = false)
	@JoinColumn(name = "room_type_id")
    RecoveryRoomType roomType;
}
