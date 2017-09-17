package com.jjly.dao;

import com.jjly.model.CmsResource;
import org.jjly.framework.orm.mybatis.MybatisBaseDao;
import org.springframework.stereotype.Repository;

/**
 * <p>系统后台资源Dao </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.dao
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:08
 */
@Repository
public interface ICmsResourceDao extends MybatisBaseDao<CmsResource,Long>{
}
