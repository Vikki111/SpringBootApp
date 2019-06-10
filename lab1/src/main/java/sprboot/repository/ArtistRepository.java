package sprboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sprboot.model.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    @Query(value = "select * from artist where lower(artist_name) = LOWER(?1) ",
            nativeQuery = true)
    List<Artist> findAllByArtistName(String artistName);
    List<Artist> findAllByOrderByArtistNameAsc();
    List<Artist> findAllByOrderByArtistNameDesc();
}
