package com.jjly.service;

import com.jjly.vo.CmsUserVO;

/**
 * <p>系统用户service类</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.service
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 10:51
 */
public interface ICmsUserService {
    /**
     * <p>
     *  说明：根据用户名获取cms后台系统用户
     * </p>
     * <p>
     *  链接：
     * </p>
     * @param userName 用户名
     * @return CmsUserVO 用户VO
     * @auth Steven
     */
    public CmsUserVO getByUserName(String userName);
}
