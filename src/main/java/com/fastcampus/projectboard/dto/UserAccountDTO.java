package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.UserAccount;

import java.time.LocalDateTime;

public record UserAccountDTO(
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static UserAccountDTO of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDTO(userId, userPassword, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDTO from(UserAccount entity) {
        return new UserAccountDTO(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }

}
