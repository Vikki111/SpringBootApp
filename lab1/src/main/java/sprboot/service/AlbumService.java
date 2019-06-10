package sprboot.service;

import sprboot.model.Album;

import java.util.List;

public interface AlbumService {

    void save(Album album);
    Album getById(int id);
    void update(Album album);
    List<Album> findAll();
    void delete(int id);
    List<Album> findAllByAlbumName(String albumName);
    List<Album> findAllByAlbumYear(int albumYear);
    List<Album> findAllByOrderByAlbumNameAsc();
    List<Album> findAllByOrderByAlbumYearAsc();
    List<Album> findAllByOrderByAlbumNameDesc();
    List<Album> findAllByOrderByAlbumYearDesc();
}
