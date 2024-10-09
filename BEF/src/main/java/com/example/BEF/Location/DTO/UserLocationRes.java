package com.example.BEF.Location.DTO;

import lombok.Data;

@Data
public class UserLocationRes {
    private Long content_id;
    private String content_title;
    private String addr;
    private String thumbnail_image;

    public UserLocationRes(Long content_id, String content_title, String addr, String thumbnail_image) {
        this.content_id = content_id;
        this.content_title = content_title;
        this.addr = addr;
        this.thumbnail_image = thumbnail_image;
    }
}
