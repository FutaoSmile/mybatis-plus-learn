package com.futao.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.futao.entity.Article;
import com.futao.mapper.ArticleMapper;
import com.futao.util.CurrentUserId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author futao
 * @date 2020/12/15
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleMapper articleMapper;

    @PostMapping
    public void add(@Validated @RequestBody AddBody addBody) {
        articleMapper.insert(new Article(addBody.title, addBody.content, CurrentUserId.s()));
    }

    @GetMapping
    public List<Article> list() {
        return articleMapper.selectList(Wrappers.<Article>lambdaQuery());
    }


    @Getter
    @Setter
    public static class AddBody {
        private String title;
        private String content;
    }


}
