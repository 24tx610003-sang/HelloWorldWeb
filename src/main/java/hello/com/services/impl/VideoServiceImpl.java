package hello.com.services.impl;

import java.util.List;
import hello.com.daos.impl.VideoDaoImpl;
import hello.com.entity.Video;
import hello.com.services.VideoService;

public class VideoServiceImpl implements VideoService {

    private VideoDaoImpl videoDao = new VideoDaoImpl();

    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public void delete(String videoId) {
        videoDao.delete(videoId);
    }

    @Override
    public Video findById(String videoId) {
        return videoDao.findById(videoId);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }
}
