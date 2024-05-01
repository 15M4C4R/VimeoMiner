package Rest.vimeo.service;

import Rest.vimeo.model.comment.Comment;
import Rest.vimeo.model.comment.CommentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    private final String token = "81b11cb93a69116057336e2958a4566b";

    public List<Comment> findAllComments(String idVideo){
        String uri = "https://api.vimeo.com/videos/"+idVideo+"/comments";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<CommentList> request = new HttpEntity<>(null,headers);
        ResponseEntity<CommentList> response =
                restTemplate.exchange(uri, HttpMethod.GET,request, CommentList.class);
        return response.getBody().getData();
    }

    public Comment findComment(String idVideo, String idComment){
        String uri = "https://api.vimeo.com/videos/"+idVideo+"/comments/"+idComment;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<Comment> request = new HttpEntity<>(null, headers);
        ResponseEntity<Comment> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,Comment.class);
        return response.getBody();
    }

    public void setComment(String idVideo, Comment comment){
        String uri = "uri de videoMiner";
        HttpEntity<Comment> request = new HttpEntity<>(comment);
        restTemplate.exchange(uri, HttpMethod.PUT,request,Comment.class);

    }

}
