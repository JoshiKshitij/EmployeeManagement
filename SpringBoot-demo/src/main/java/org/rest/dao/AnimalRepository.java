package org.rest.dao;

import org.rest.dto.AnimalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalDto, Integer> {

}
