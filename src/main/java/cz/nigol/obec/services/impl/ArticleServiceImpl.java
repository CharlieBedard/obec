package cz.nigol.obec.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.nigol.obec.entities.Article;
import cz.nigol.obec.entities.User;
import cz.nigol.obec.services.ArticleService;

@Stateless
public class ArticleServiceImpl implements ArticleService {
    @PersistenceContext(unitName="obecPU")
    private EntityManager em;

    @Override
    public List<Article> getAllArticles() {
        TypedQuery<Article> typedQuery = em.createNamedQuery(Article.GET_ALL, Article.class);
        return new ArrayList<>(typedQuery.getResultList());
    }

    @Override
    public Article getArticleById(String id) {
        return em.find(Article.class, id);
    }

    @Override
    public Article saveArticle(Article article, String body) {
        Article result = em.merge(article);
        result.setBody(body);
        return result;
    }

    @Override
    public Article loadArticleBody(Article article) {
        Article result = em.find(Article.class, article.getId());
        result.setBody(result.getBody());
        return result;
    }

    @Override
    public List<Article> getArticlesByUser(User user) {
        TypedQuery<Article> typedQuery = em.createNamedQuery(Article.GET_BY_USER, Article.class);
        typedQuery.setParameter(Article.USER_PARAM, user);
        return new ArrayList<>(typedQuery.getResultList());
    }

    @Override
    public void deleteArticle(Article article) {
        em.remove(em.merge(article));
    }

    @Override
    public List<Article> getArticlesByPattern(String pattern) {
        TypedQuery<Article> typedQuery = em.createNamedQuery(Article.GET_BY_PATTERN,
                Article.class);
        typedQuery.setParameter(Article.PATTERN_PARAM, pattern);
        return new ArrayList<>(typedQuery.getResultList());
    }
}
