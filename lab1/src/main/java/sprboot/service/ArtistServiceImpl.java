package sprboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sprboot.model.Artist;
import sprboot.repository.ArtistRepository;
import sprboot.service.ArtistService;

import java.util.List;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository repository;

    @Override
    public void save(Artist artist) {
        repository.save(artist);
    }

    @Override
    public Artist getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void update(Artist artist) {
        Artist updated = repository.getOne(artist.getId());
        updated.setArtistName(artist.getArtistName());
        repository.save(updated);
    }

    @Override
    public List<Artist> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Artist> findAllByArtistName(String artistName){
        return repository.findAllByArtistName(artistName);
    }

    @Override
    public List<Artist> findAllByOrderByArtistNameAsc(){
        return repository.findAllByOrderByArtistNameAsc();
    }

    @Override
    public List<Artist> findAllByOrderByArtistNameDesc() {
        return repository.findAllByOrderByArtistNameDesc();
    }
}
