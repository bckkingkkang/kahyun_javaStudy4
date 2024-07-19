package org.example.imagedrag.controller;

import lombok.RequiredArgsConstructor;
import org.example.imagedrag.mapper.ImageMapper;
import org.example.imagedrag.vo.ImageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ImageMapper imageMapper;

    @RequestMapping("/main")
    public ModelAndView Main(ModelAndView mav) {
        List<ImageVo> getImage = imageMapper.getList();
        System.out.println(getImage);
        mav.addObject("image",getImage);
        mav.setViewName("main");
        return mav;
    }

    @ResponseBody
    @PostMapping("/change_image")
    public void changeImage(ImageVo imageVo) {
        imageMapper.draggedImage(imageVo);
        imageMapper.droppedImage(imageVo);


    }

}
