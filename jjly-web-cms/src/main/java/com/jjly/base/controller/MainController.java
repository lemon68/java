package com.jjly.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jjly.framework.result.ResultUtils;
import org.jjly.framework.result.domain.Result;
import org.jjly.framework.security.springsecurity.SpringSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjly.client.ICmsResourceClient;
import com.jjly.client.ICmsUserClient;
import com.jjly.model.CmsResource;
import com.jjly.model.CmsUser;
import com.jjly.vo.NavResource;

/**
 * <p>主页controller</p>
 *
 * @author Steven
 * @version V1.0
 * @Package com.jjly.base.controller
 * @e-mail 47121494@qq.com
 * @date 2017/9/15 9:00
 */
@Controller
@RequestMapping("main")
public class MainController {
    @Autowired
    private ICmsUserClient cmsUserClient;
    @Autowired
    private ICmsResourceClient cmsResourceClient;

    @RequestMapping("")
    public String main(HttpServletRequest request) {
        // 获取用户信息
//        CmsUser user = cmsUserClient.getByUserName(SpringSecurityUtils
//                .getCurrentUserName());
//        cmsUserClient.saveAndModify(user);
//        HttpSession session = request.getSession();
//        session.setAttribute("user", user);
//        String topResIdstr = request.getParameter("topResId");
//        if (StringUtils.isEmpty(topResIdstr)) {
//            NavResource firstTopNavResource = getCurrUserTopFirstNavResource(user
//                    .getId());
//            if (firstTopNavResource != null) {
//                request.setAttribute("topResId", firstTopNavResource.getId());
//                request.setAttribute("defLoadUrl",
//                        firstTopNavResource.getMenuUrl());
//            } else {
//                request.setAttribute("defLoadUrl", "");
//            }
//        } else {
//            request.setAttribute("topResId", topResIdstr);
//            CmsResource resource = cmsResourceClient
//                    .get(Long.parseLong(topResIdstr));
//            request.setAttribute("defLoadUrl", resource.getUrl());
//        }
        List<CmsResource> cmsResourceList=cmsResourceClient.getResourcesByLevel(0);
        return "main";
    }

    @RequestMapping("/{topResId}")
    public String main(
            @PathVariable(value = "topResId") Long topResId,

            @RequestParam(value = "url", defaultValue = "", required = false) String url,

            Model model, HttpServletRequest request) {
        if (topResId != null && topResId != -1) {
            request.setAttribute("topResId", topResId);
            CmsResource resource = cmsResourceClient.get(topResId);
            model.addAttribute("defLoadUrl", resource.getUrl());
        }

        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("defLoadUrl", url);
        }
        return "main";
    }

    /**
     *
     * <p>
     * 说明：获取当前用户一级菜单的第一个菜单
     * </p>
     *
     * @return
     * @author Steven
     */
    private NavResource getCurrUserTopFirstNavResource(
            Long userId) {
        List<NavResource> allUserResources = cmsResourceClient
                .getResourcesNavByUser(userId);
        List<NavResource> headSetResources = NavResource
                .getHeadResources(allUserResources);
        if (CollectionUtils.isNotEmpty(headSetResources)) {
            return headSetResources.get(0);
        }
        return null;
    }

    @RequestMapping("menu")
    public String menu(Model model, HttpServletRequest request) {
        CmsUser user = (CmsUser) request.getSession().getAttribute("user");
        List<CmsResource> resources = cmsResourceClient.getResourcesByUser(user
                .getId());
        model.addAttribute("resources", resources);
        return "menu";
    }

    @RequestMapping("menu-json")
    @ResponseBody
    public Result<List<CmsResource>> menuJSON(Model model,
                                              HttpServletRequest request) {
        CmsUser user = (CmsUser) request.getSession().getAttribute("user");
        List<CmsResource> resources = cmsResourceClient.getResourcesByUser(user
                .getId());
        return ResultUtils.returnSuccess("", resources);
    }
    @RequestMapping("layout1")
    public String layout1(Model m){
        return "temp/layout-1";
    }
    @RequestMapping("layout2")
    public String layout2(Model m){
        return "temp/layout-2";
    }
   @RequestMapping("layout3")
    public String layout3(Model m){
        return "temp/layout-3";
    }
}
