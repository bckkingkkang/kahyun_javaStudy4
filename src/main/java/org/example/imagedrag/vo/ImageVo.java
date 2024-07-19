package org.example.imagedrag.vo;

import lombok.Data;

@Data
public class ImageVo {
    private int seq;
    private String image_name;
    private String saved_path;
    private String location_num;

    private String dropped_num;
    private String dragged_seq;
    private String dragged_num;
    private String dropped_seq;
}
