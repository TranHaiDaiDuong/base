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
public class DemoEntity implements Serializable {
    private static final long serialVersionUID = -9101769777475931647L;
    private Integer id;
    private String fullName;
    private LocalDateTime dateOfBirth;
    private String imageLink;
    private String privateInfo;
}
