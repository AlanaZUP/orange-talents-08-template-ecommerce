package com.orangetalents.mercadolivre.produto.imagens;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public class Upload implements Uploader{

    @Override
    public Collection<String> enviaImagensParaServidorFake(Collection<MultipartFile> imagens) {
        return imagens.stream().map(imagem -> );
    }
}
