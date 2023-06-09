package com.rungroup.web.service;

import static com.rungroup.web.mapper.ClubMapper.mapToClub;
import static com.rungroup.web.mapper.ClubMapper.mapToClubDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.repository.ClubRepository;
@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;
	
	

    @Autowired
	public ClubServiceImpl(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
		
	}

	@Override
    public void updateClub(ClubDto clubDto) {
		Club club = mapToClub(clubDto);
        clubRepository.save(club);       
    }
    
	@Override
	public Club saveClub(ClubDto clubDto) {
		Club club = mapToClub(clubDto);
		return this.clubRepository.save(club);
	}
	
	@Override
	public void delete(Long clubId) {
		clubRepository.deleteById(clubId);
	}
	
	@Override
	public List<ClubDto> searchClubs(String query) {
		List<Club> clubs = clubRepository.searchClubs(query);
		
		return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
	}
	


    @Override
    public ClubDto findClubById(long clubId) {
        Club club = this.clubRepository.findById(clubId).get();
		return mapToClubDto(club);
    }
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = this.clubRepository.findAll();

        return clubs.stream()
		        .map(club -> mapToClubDto(club))
            .collect(Collectors.toList());
    }



	
}

