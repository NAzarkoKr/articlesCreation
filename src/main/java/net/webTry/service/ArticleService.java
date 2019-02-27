package net.webTry.service;

import net.webTry.dao.ArticleRepository;
import net.webTry.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public void save(Article article){
        repository.save(article);
    }

    public List<Article> getAll(){
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
