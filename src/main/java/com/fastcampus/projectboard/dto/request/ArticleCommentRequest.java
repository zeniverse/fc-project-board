package com.fastcampus.projectboard.dto.request;

import com.fastcampus.projectboard.dto.ArticleCommentDTO;
import com.fastcampus.projectboard.dto.UserAccountDTO;

public record ArticleCommentRequest(
        Long articleId,
        String content
) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDTO toDTO(UserAccountDTO userAccountDTO){
        return ArticleCommentDTO.of(
                articleId,
                userAccountDTO,
                content
        );
    }
}
