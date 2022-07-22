package com.fastcampus.projectboard.dto.response;

import com.fastcampus.projectboard.dto.ArticleCommentDTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleCommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,
        String nickname,
        String userId
) implements Serializable {

    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname, String userId) {
        return new ArticleCommentResponse(id, content, createdAt, email, nickname, userId);
    }

    public static ArticleCommentResponse from(ArticleCommentDTO dto) {
        String nickname = dto.userAccountDTO().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDTO().userId();
        }

        return new ArticleCommentResponse(
                dto.id(),
                dto.content(),
                dto.createdAt(),
                dto.userAccountDTO().email(),
                nickname,
                dto.userAccountDTO().userId()
        );
    }

}
