package sprboot.service;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sprboot.model.Album;
import sprboot.repository.AlbumRepository;
import sprboot.service.AlbumService;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository repository;

    @Override
    public void save(Album album) {
        repository.save(album);
    }

    @Override
    public Album getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void update(Album album) {
        Album updated = repository.getOne(album.getId());
        updated.setAlbumName(album.getAlbumName());
        updated.setAlbumYear(album.getAlbumYear());
        updated.setArtistId(album.getArtistId());
        repository.save(updated);
    }

    @Override
    public List<Album> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Album> findAllByAlbumName(String albumName) {
        return repository.findAllByAlbumName(albumName);
    }

    @Override
    public List<Album> findAllByAlbumYear(int albumYear) {
        return repository.findAllByAlbumYear(albumYear);
    }

    @Override
    public List<Album> findAllByOrderByAlbumNameAsc() {
        return repository.findAllByOrderByAlbumNameAsc();
    }

    @Override
    public List<Album> findAllByOrderByAlbumYearAsc() {
        return repository.findAllByOrderByAlbumYearAsc();
    }

    @Override
    public List<Album> findAllByOrderByAlbumNameDesc() {
        return repository.findAllByOrderByAlbumNameDesc();
    }

    @Override
    public List<Album> findAllByOrderByAlbumYearDesc() {
        return repository.findAllByOrderByAlbumYearDesc();
    }
}
