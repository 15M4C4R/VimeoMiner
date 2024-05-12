package Rest.vimeo.service;

import Rest.vimeo.model.Vimeo.comment.CommentVimeo;
import Rest.vimeo.model.Vimeo.comment.CommentList;
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

    public List<CommentVimeo> findAllComments(String idVideo, int maxComments){
        String uri = "https://api.vimeo.com/videos/"+idVideo+"/comments?page=1&per_page=" + maxComments;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<CommentList> request = new HttpEntity<>(null,headers);
        ResponseEntity<CommentList> response =
                restTemplate.exchange(uri, HttpMethod.GET,request, CommentList.class);
        return response.getBody().getData();
    }

    public CommentVimeo findComment(String idVideo, String idComment){
        String uri = "https://api.vimeo.com/videos/"+idVideo+"/comments/"+idComment;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<CommentVimeo> request = new HttpEntity<>(null, headers);
        ResponseEntity<CommentVimeo> response =
                restTemplate.exchange(uri, HttpMethod.GET,request, CommentVimeo.class);
        return response.getBody();
    }

    public void setComment(String idVideo, CommentVimeo comment){
        String uri = "uri de videoMiner";
        HttpEntity<CommentVimeo> request = new HttpEntity<>(comment);
        restTemplate.exchange(uri, HttpMethod.PUT,request, CommentVimeo.class);

    }

}
