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
public class DemoViewable {
    private Integer id;
    //private String sex;
    private String fullName;
    private LocalDateTime dateOfBirth;
    private String avatarLink;
}
