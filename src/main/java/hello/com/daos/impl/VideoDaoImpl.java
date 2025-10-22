package hello.com.daos.impl;

import hello.com.entity.Video;

public class VideoDaoImpl extends AbstractEntityDao<Video> {
    public VideoDaoImpl() {
        super(Video.class);
    }
}
