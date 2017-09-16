package com.jjly.client.impl;

import com.jjly.client.ICmsResourceClient;
import com.jjly.model.CmsResource;
import com.jjly.vo.NavResource;

import java.util.List;

/**
 * <p>系统后台资源client实现类</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.client.impl
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:13
 */
public class CmsResourceClientImpl implements ICmsResourceClient {
    @Override
    public CmsResource get(long id) {
        return null;
    }

    @Override
    public List<NavResource> getResourcesNavByUser(Long userId) {
        return null;
    }

    @Override
    public List<CmsResource> getResourcesByUser(Long id) {
        return null;
    }
}
