package com.gst.base.remote.service;

import com.gst.base.remote.entity.DemoEntity;

import javax.ejb.Remote;

@Remote
public interface DemoBeanRemote {
    DemoEntity findByName(String name);
}
