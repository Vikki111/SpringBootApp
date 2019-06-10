package sprboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sprboot.model.Composition;
import sprboot.repository.CompositionRepository;

import java.util.List;

@Service
@Transactional
public class CompositionServiceImpl implements CompositionService {

    @Autowired
    private CompositionRepository repository;

    @Override
    public void save(Composition composition) {
        repository.save(composition);
    }

    @Override
    public Composition getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void update(Composition composition) {
        Composition updated = repository.getOne(composition.getId());
        updated.setCompName(composition.getCompName());
        updated.setAlbumId(composition.getAlbumId());
        repository.save(updated);
    }

    @Override
    public List<Composition> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Composition> findAllByCompName(String compName){
        return repository.findAllByCompName(compName);
    }

    @Override
    public List<Composition> findAllByOrderByCompNameAsc() {
        return repository.findAllByOrderByCompNameAsc();
    }

    @Override
    public List<Composition> findAllByOrderByCompNameDesc() {
        return repository.findAllByOrderByCompNameDesc();
    }
}
