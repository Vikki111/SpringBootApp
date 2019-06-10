package sprboot.service;

import sprboot.model.Artist;

import java.util.List;

public interface ArtistService {

    void save(Artist artist);
    Artist getById(int id);
    void update(Artist artist);
    List<Artist> findAll();
    void delete(int id);
    List<Artist> findAllByArtistName(String artistName);
    List<Artist> findAllByOrderByArtistNameAsc();
    List<Artist> findAllByOrderByArtistNameDesc();
}
