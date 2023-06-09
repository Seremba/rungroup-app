package com.rungroup.web.mapper;

import static com.rungroup.web.mapper.EventMapper.mapToEventDto;

import java.util.stream.Collectors;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;

public class ClubMapper {
	
	public static Club mapToClub(ClubDto club) {
		return Club.builder().id(club.getId()).title(club.getTitle()).photoUrl(club.getPhotoUrl()).content(club.getContent())
		        .createdOn(club.getCreatedOn()).updatedOn(club.getUpdatedOn()).build();
	}
	

	public static ClubDto mapToClubDto(Club club) {
		return ClubDto.builder().id(club.getId()).title(club.getTitle()).photoUrl(club.getPhotoUrl())
		        .content(club.getContent()).createdOn(club.getCreatedOn()).updatedOn(club.getUpdatedOn())
		        .events(club.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
		        
		        .build();
		
	}
	
}
