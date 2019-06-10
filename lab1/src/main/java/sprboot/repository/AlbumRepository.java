package sprboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sprboot.model.Album;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "select * from album where lower(album_name) = LOWER(?1) ",
            nativeQuery = true)
    List<Album> findAllByAlbumName(String albumName);
    List<Album> findAllByAlbumYear(int albumYear);
    List<Album> findAllByOrderByAlbumNameAsc();
    List<Album> findAllByOrderByAlbumYearAsc();
    List<Album> findAllByOrderByAlbumNameDesc();
    List<Album> findAllByOrderByAlbumYearDesc();
}
