package com.orangetalents.mercadolivre.produto.imagens;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class UploadFake implements Uploader{

    @Override
    public List<String> enviaImagensParaServidorFake(List<MultipartFile> imagens) {
        return imagens.stream().map(imagem -> "http://"+imagem.getOriginalFilename()).collect(Collectors.toList());
    }
}
