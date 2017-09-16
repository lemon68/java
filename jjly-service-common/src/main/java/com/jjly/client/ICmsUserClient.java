package com.jjly.client;

import com.jjly.model.CmsUser;
import com.jjly.vo.CmsUserVO;

/**
 * <p>//TODO(描述该类的功能) </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.client
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 10:45
 */
public interface ICmsUserClient {
    /**
     * <p>
     *  说明：根据用户名获取用户
     * </p>
     * <p>
     *  链接：
     * </p>
     * @param userName 用户名
     * @return CmsUserVO 用户VO
     * @auth Steven
     */
    public CmsUser getByUserName(String userName);
    /**
     * <p>
     *  说明：保存或更新系统用户
     * </p>
     * <p>
     *  链接：
     * </p>
     * @param user 系统用户
     * @return null
     * @auth Steven
     */
    public void saveAndModify(CmsUser user);
}
