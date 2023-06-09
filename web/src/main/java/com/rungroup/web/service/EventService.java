package com.rungroup.web.service;

import java.util.List;

import com.rungroup.web.dto.EventDto;

public interface EventService {
	
	void createEvent(Long clubId, EventDto eventDto);
	
	List<EventDto> findAllEvents();
	
	EventDto findEventById(Long eventId);
	
	void updateClub(EventDto eventDto);
	
	void deleteEvent(Long eventId);
}
