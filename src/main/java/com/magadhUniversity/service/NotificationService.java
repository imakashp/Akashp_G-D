package com.magadhUniversity.service;

import com.magadhUniversity.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();
    void saveNotification(Notification notification);
}
