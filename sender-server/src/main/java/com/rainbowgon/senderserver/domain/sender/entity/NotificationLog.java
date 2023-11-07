package com.rainbowgon.senderserver.domain.sender.entity;

import com.rainbowgon.senderserver.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", columnDefinition = "INT UNSIGNED")
    private Long id;

    private Long profileId;
    private Long themeId;
    private String title;
    private String body;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'ETC'")
    private NotificationType notificationType;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'NOT_VIEWED'")
    private ViewStatus viewStatus = ViewStatus.NOT_VIEWED;

    @Builder
    public Notification(Long profileId, Long themeId, String title, String body,
                        NotificationType notificationType, ViewStatus viewStatus) {
        this.profileId = profileId;
        this.themeId = themeId;
        this.title = title;
        this.body = body;
        this.notificationType = notificationType;
        this.viewStatus = viewStatus;
    }
}