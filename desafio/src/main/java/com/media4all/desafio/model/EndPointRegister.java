package com.media4all.desafio.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "end_point_register")
public class EndPointRegister implements Serializable {
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "end_point_register_id_seq", strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private String content;
}
