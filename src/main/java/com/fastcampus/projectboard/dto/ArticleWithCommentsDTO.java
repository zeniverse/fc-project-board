package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.Article;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentsDTO(
        Long id,
        UserAccountDTO userAccountDTO,
        Set<ArticleCommentDTO> articleCommentDTOs,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static ArticleWithCommentsDTO of(Long id, UserAccountDTO userAccountDTO, Set<ArticleCommentDTO> articleCommentDTOs, String title, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleWithCommentsDTO(id, userAccountDTO, articleCommentDTOs, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleWithCommentsDTO from(Article entity) {
        return new ArticleWithCommentsDTO(
                entity.getId(),
                UserAccountDTO.from(entity.getUserAccount()),
                entity.getArticleComments().stream()
                        .map(ArticleCommentDTO::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

}
