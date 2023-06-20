package com.gst.base.service.viewable.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentViewable {
    private Integer id;
    private String sex;
    private String name;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;
    private String imageL;
}
