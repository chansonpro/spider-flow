package org.spiderflow.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.spiderflow.core.model.DataSource;
import org.spiderflow.core.model.Function;
import org.spiderflow.core.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础功能处理器
 */
@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    /**
     * 查询所有爬虫任务 list返回
     * @param page
     * @param size
     * @param name
     * @return
     */
    @RequestMapping("/list")
    public IPage<Function> list(@RequestParam(name = "page",defaultValue = "1")Integer page, @RequestParam(name = "limit",defaultValue = "1")Integer size,String name) {
        QueryWrapper<Function> select = new QueryWrapper<Function>().select("id", "name", "parameter", "create_date");
        if(StringUtils.isNotBlank(name)){
            select.like("name",name);
        }
        select.orderByDesc("create_date");
        return functionService.page(new Page<Function>(page, size), select);
    }

    /**
     * 保存
     * @param function
     * @return
     */
    @RequestMapping("/save")
    public String save(Function function){
        return functionService.saveFunction(function);
    }

    /**
     * 基于特定的id查询详情
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public Function get(String id){
        return functionService.getById(id);
    }

    /**
     * 基于某个id删除
     * @param id
     */
    @RequestMapping("/remove")
    public void remove(String id){
        functionService.removeById(id);
    }
}
