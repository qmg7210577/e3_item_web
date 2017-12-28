package com.e3mall.item.controller;

import com.e3mall.item.pojo.Item;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemDesc;
import com.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qimenggao on 2017/12/28.
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("item/{id}")
    public String showItemInfo(@PathVariable("id")Long id, Model model){
//        调用服务查询基本信息
        TbItem tbItem = itemService.selectByPrimaryKey(id);
        Item item = new Item(tbItem);
//        调用服务查询商品描述信息
        TbItemDesc itemDesc = itemService.selectItemDescById(id);
//        将商品信息和描述信息添加至model
        model.addAttribute("item",item);
        model.addAttribute("itemDesc",itemDesc);
        return "item";
    }

}
