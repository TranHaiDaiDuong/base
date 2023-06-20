
package com.gst.base.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenContext {
    private String phoneNumber;
    private String refreshToken;
    private String deviceId;

    @Override
    public String toString() {
        return "RefreshTokenContext{" + "username=" + phoneNumber
                + ", refreshToken=" + refreshToken + ", deviceId=" + deviceId + '}';
    }
}
