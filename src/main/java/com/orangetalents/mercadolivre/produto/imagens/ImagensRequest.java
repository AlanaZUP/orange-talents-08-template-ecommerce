package com.orangetalents.mercadolivre.produto.imagens;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ImagensRequest {

    @Size(min = 1) @NotNull
    private List<MultipartFile> imagens;

    public List<MultipartFile> getImagens() {
        return imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }
}
