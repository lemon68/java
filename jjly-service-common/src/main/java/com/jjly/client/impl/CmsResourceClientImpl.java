package com.jjly.client.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jjly.client.ICmsResourceClient;
import com.jjly.model.CmsResource;
import com.jjly.service.ICmsResourceService;
import com.jjly.vo.NavResource;
import org.jjly.framework.bean.MyBeanUtils;
import org.jjly.framework.collection.MyCollectionUtils;
import org.jjly.framework.mybatis.paginator.domain.Order;
import org.jjly.framework.orm.OperatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>系统后台资源client实现类</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.client.impl
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 11:13
 */
@Service("cmsUserClient")
public class CmsResourceClientImpl implements ICmsResourceClient {
    @Autowired
    private ICmsResourceService cmsResourceService;
    @Override
    public CmsResource get(long id) {
        return null;
    }

    @Override
    public List<NavResource> getResourcesNavByUser(Long userId) {
        return null;
    }

    @Override
    public List<CmsResource> getResourcesByUser(Long userId) {
        return null;
    }

    @Override
    public List<NavResource> getNavResourcesByLevel(Integer level) {

        List<NavResource> navResources= Lists.newArrayList();
        List<CmsResource> cmsResourceList=this.getResourcesByLevel(level);
        for(CmsResource cmsResource:cmsResourceList){
            NavResource navResource=MyBeanUtils.copyProperty(cmsResource,NavResource.class);
            List<CmsResource> cmsResourceChildren=this.getResourcesByLevel(cmsResource.getId().intValue());
            if(MyCollectionUtils.isNotEmpty(cmsResourceChildren)){
                navResource.setHaveChild(true);
                List<NavResource> navResourceChildren=MyBeanUtils.copyProperty(cmsResourceChildren,NavResource.class);
                navResource.setSub(navResourceChildren);
                navResources.add(navResource);
            }
        }
        return navResources;
    }
    /**
     * <p>
     *  说明：
     * </p>
     * <p>
     *  链接：
     * </p>
     * @param parentId
     * @return java.util.List<com.jjly.model.CmsResource>
     * @auth Steven
     */
    @Override
    public List<CmsResource> getResourcesByParentId(Long parentId) {
        Map<String,Object> mapCondition=Maps.newHashMap();
        mapCondition.put(OperatorEnum.EQ.op("pid"),parentId);
        return cmsResourceService.findByCondition(mapCondition);
    }
    @Override
    public List<CmsResource> getResourcesByLevel(Integer level){
        Map<String,Object> mapCondition= Maps.newHashMap();
        mapCondition.put(OperatorEnum.EQ.op("level"),level);
        List<Order> orders=Lists.newArrayList();
        Order order=new Order("sort",Order.Direction.ASC,null);
        orders.add(order);
        return cmsResourceService.findByCondition(mapCondition,orders);
    }

    @Override
    public List<NavResource> getNavResourcesByParentId(Long parentId) {
        return null;
    }
}
