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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "STAFF")
@NamedQuery(name = "Staff.findByPhoneNumber", query = "select s from Staff s where s.phoneNumber = :phoneNumber")

@NamedQuery(name = "Staff.findByTeamId", query = "select s from Staff s where s.team.id = :teamId")

//id của team = giá trị truyền vào
@NamedQuery(name = "Staff.findByTeamIdAge", query = "select s from Staff s where s.team.id = :teamId ORDER BY s.birthDay ASC ")

@NamedQuery(name = "Staff.findByName", query = "select s from Staff s where s.name like '%d%' ")
public class Staff implements Serializable {

    public static final String POSITION_LEADER = "Leader";
    public static final String POSITION_CAPTION = "Caption";
    public static final String POSITION_STAFF = "Staff";
    @Id
    @Column
    @SequenceGenerator(name = "SEQ_GEN_STAFF", allocationSize = 1 , sequenceName = "SEQ_STAFF")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_STAFF")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH_DAY")
    private LocalDateTime birthDay;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "ID")
    private Team team;

    @Column(name = "POSITION")
    private String position;
}
