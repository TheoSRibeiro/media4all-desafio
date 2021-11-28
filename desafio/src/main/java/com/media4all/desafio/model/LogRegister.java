package com.media4all.desafio.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "log_register")
public class LogRegister implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "log_register_id_seq",strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String createDate;

    @Column(nullable = false)
    private String ip;

    private String content;
}
