package com.jjly.client;

import com.jjly.model.CmsResource;
import com.jjly.vo.NavResource;

import java.util.List;

/**
 * <p>系统后台资源client接口</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.client
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:12
 */
public interface ICmsResourceClient {
    /**
     * <p>
     *  说明：根据主键获取系统资源
     * </p>
     * <p>
     *  链接：
     * </p>
     *  @param id
     *  @return CmsResource
     * @auth Steven
     */
    public CmsResource get(long id);
    /**
     * <p>
     *  说明：获取用户所拥有的资源
     * </p>
     * <p>
     *  链接：
     * </p>
     * @param userId 用户id
     * @return null
     * @auth Steven
     */
    public List<NavResource> getResourcesNavByUser(Long userId);

    public List<CmsResource> getResourcesByUser(Long id);

}
