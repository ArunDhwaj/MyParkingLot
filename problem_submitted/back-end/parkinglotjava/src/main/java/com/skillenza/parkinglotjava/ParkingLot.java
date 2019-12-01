package com.skillenza.parkinglotjava;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
    //your code goes here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name ="id", length = 20)
    private Long id;

    @JsonIgnore
    @CreatedDate
    @NotNull
    @Column(name="created_at")
    private Instant created_at;

    @Column(name="lot", unique=true, length = 11)
    @NotNull
    private int lot;

    @Column(name="parking_amount", length = 11)
    @NotNull
    private int parking_amount;

    @Column(name="parking_duration", length = 11)
    @NotNull
    private int parking_duration;

    @JsonIgnore
    @CreatedDate
    @NotNull
    @Column(name="updated_at")
    private Instant updated_at;

    @Column(name="vehicle_number", unique=true, length = 11)
    @NotNull
    private int vehicle_number;

}
