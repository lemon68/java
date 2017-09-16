package com.jjly.dao;

import com.jjly.vo.CmsUserVO;

/**
 * <p>后台用户dao </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.dao
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 10:43
 */
public interface ICmsUserDao {
    /**
     * <p>
     *  说明：根据用户名获取系统后台用户
     * </p>
     * <p>
     *  链接：
     * </p>
     * @param userName 用户名
     * @return CmsUserVO  系统后台用户VO
     * @auth Steven
     */
    public CmsUserVO getByUserName(String userName);
}
