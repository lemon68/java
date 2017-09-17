package com.jjly.base.controller.resource;

import java.util.List;

import com.jjly.vo.NavResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.jjly.client.ICmsIconClient;
import com.jjly.client.ICmsResourceClient;
import com.jjly.client.ICmsRoleClient;
import com.jjly.model.CmsResource;

/**
 * <p>资源控制器 </p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.base.controller.resource
 * @e-mail 47121494@qq.com
 * @date 2017/9/17 11:38
 */
@Controller
@RequestMapping("resource")
public class ResourceController {
    @Autowired
    private ICmsResourceClient cmsResourceClient;
    @Autowired
    private ICmsIconClient cmsIconClient;
    @Autowired
    private ICmsRoleClient cmsRoleClient;

    @RequestMapping("resourceList")
    public String resourceList(Model model,@RequestParam(value ="id", defaultValue = "0",required = false) Long id) {
        List<NavResource> datas= Lists.newArrayList();
        if(id==0){
            datas=cmsResourceClient.getNavResourcesByLevel(0);
        }else{
            datas=cmsResourceClient.getNavResourcesByParentId(id);
        }
        model.addAttribute("datas",datas);
        return "resource/resource-list";
    }

}
