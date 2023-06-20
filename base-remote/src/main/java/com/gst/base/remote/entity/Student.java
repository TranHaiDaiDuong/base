package com.gst.base.remote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {

    public static final LocalDateTime FIXED_TIME = LocalDateTime.of(2000, 1, 1, 2, 0);
    private static final long serialVersionUID = -9101769777475931647L;
    private Integer id;
    private String sex;
    private String name;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;
    private String image;
}
