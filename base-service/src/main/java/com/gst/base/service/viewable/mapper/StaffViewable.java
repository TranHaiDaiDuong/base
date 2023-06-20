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
public class StaffViewable {
    private Integer id;
    private String name;
    private LocalDateTime birthDay;
    private String phoneNumber;
    private String email;
    private String position;
}
