package com.shuanger.springbootexample.idGenerator.controller;

import com.shuanger.springbootexample.idGenerator.service.IdGeneratorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-06-17 18:30
 * @description:
 */
@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Resource
    private IdGeneratorService idGeneratorSerivce;

    @RequestMapping("/id")
    private String gerenateId() {
      return idGeneratorSerivce.generateProviderId();
    }
}
