package com.jjly.cms.controller.goods;

import com.jjly.model.CmsResource;
import com.jjly.model.goods.ItemCate;
import com.jjly.service.goods.IGoodsItemCateService;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>//TODO商品管理 </p >
 * @Package com.jjly.cms.controller.goods 
 * @author Helen
 * @e-mail 717922789@qq.com
 * @date 2017/9/19 11:31 
 * @version V1.0
 */

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private IGoodsItemCateService iGoodsItemCateService;

    /**
     * 商品分类列表
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/getItemCateList")
    public String goodsItemCate(ItemCate itemCate, Model model, HttpServletRequest request) {
        List<ItemCate> result = iGoodsItemCateService.getItemCateList(itemCate);
        model.addAttribute("result", result);
        return "";
    }
}
