package io.tusted.article.endpoint;

import io.tusted.article.entity.Article;
import io.tusted.article.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/article")
public class ArticleEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(ArticleEndpoint.class);

    @Autowired
    private IArticleService articleService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticleDetails() {
        List<Article> list = articleService.getAllArticles();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticleById(@PathParam("id") Integer id) {
        Article article = articleService.getArticleById(id);
        return Response.ok(article).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addArticle(Article article) {
       boolean isAdded = articleService.addArticle(article);
       if(!isAdded) {
           logger.info("Article already exists.");
           return Response.status(Response.Status.CONFLICT).build();
       }

       return Response.created(URI.create("/spring-app/article/" + article.getArticleId())).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateArticle(Article article) {
        articleService.updateArticle(article);
        return Response.ok(article).build();
    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteArticle(@PathParam("id") Integer id) {
        articleService.deleteArticle(id);
        return Response.noContent().build();
    }

}
