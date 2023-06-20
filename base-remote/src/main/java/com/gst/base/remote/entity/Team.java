package com.gst.base.remote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
public class Team implements Serializable {
    @Id
    @Column
    @SequenceGenerator(name = "SEQ_GEN_TEAM", allocationSize = 1, sequenceName = "SEQ_TEAM")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_TEAM")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

}
