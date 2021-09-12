package com.orangetalents.mercadolivre.produto.imagens;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface Uploader {

    List<String> enviaImagensParaServidorFake(List<MultipartFile> imagens);
}
