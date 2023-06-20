
package com.gst.base.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientContext {

    private String phoneNumber;
    private boolean published;

}
