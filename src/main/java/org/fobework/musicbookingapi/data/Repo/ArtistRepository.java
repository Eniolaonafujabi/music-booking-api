package org.fobework.musicbookingapi.data.Repo;

import org.fobework.musicbookingapi.data.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> { }

