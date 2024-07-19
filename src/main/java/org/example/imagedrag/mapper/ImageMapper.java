package org.example.imagedrag.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.imagedrag.vo.ImageVo;

import java.util.List;

@Mapper
public interface ImageMapper {
    List<ImageVo> getList();
    void draggedImage(ImageVo imageVo);
    void droppedImage(ImageVo imageVo);

}
