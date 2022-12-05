package fr.certif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.certif.model.Channel;

@Repository
public interface ChannelRepository  extends JpaRepository<Channel, Long> {
	
}