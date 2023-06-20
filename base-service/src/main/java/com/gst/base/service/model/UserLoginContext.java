
package com.gst.base.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginContext implements Serializable {

    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private String otp;
    private String deviceId;
}
