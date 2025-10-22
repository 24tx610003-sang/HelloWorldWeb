package hello.com.services;

import java.util.List;
import hello.com.entity.Video;

public interface VideoService {
    void insert(Video video);
    void update(Video video);
    void delete(String videoId);
    Video findById(String videoId);
    List<Video> findAll();
}
