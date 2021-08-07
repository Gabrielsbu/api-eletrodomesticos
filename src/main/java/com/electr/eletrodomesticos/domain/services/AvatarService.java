package com.electr.eletrodomesticos.domain.services;


import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AvatarService {

    String createImageInServer(MultipartFile picture);

    Resource loadPicture(String pictureName);

    String savePictureOnDisc(MultipartFile picture);
}