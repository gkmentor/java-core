package org.hagiakinh.design_pattern.structural.facade;

import java.io.File;
import org.hagiakinh.design_pattern.structural.facade.facade.VideoConversionFacade;

public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}