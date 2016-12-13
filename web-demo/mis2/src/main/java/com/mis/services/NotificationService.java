package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.Notification;
import com.mis.repositories.NotificationRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	public int createNotification(Notification notification) {
		notificationRepository.save(notification);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateNotification(Notification notification) {
		notificationRepository.save(notification);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteNotification(Notification notification) {
		notificationRepository.delete(notification);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Notification findById(Integer id) {
		return notificationRepository.findOne(id);
	}

	public List<Notification> getAll() {
		Iterator<Notification> it = notificationRepository.findAll().iterator();
		List<Notification> list = new ArrayList<Notification>();
		for (; it.hasNext();) {
			list.add((Notification) it.next());
		}
		return list;
	}
	
	public List<Notification> getAll(Pageable pageable) {
		Iterator<Notification> it = notificationRepository.findAll(pageable).iterator();
		List<Notification> list = new ArrayList<Notification>();
		for (; it.hasNext();) {
			list.add((Notification) it.next());
		}
		return list;
	}
	
	
}