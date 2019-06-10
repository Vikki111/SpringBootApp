package sprboot.service;

import sprboot.model.Composition;

import java.util.List;

public interface CompositionService {

    void save(Composition composition);
    Composition getById(int id);
    void update(Composition composition);
    List<Composition> findAll();
    void delete(int id);
    List<Composition> findAllByCompName(String compName);
    List<Composition> findAllByOrderByCompNameAsc();
    List<Composition> findAllByOrderByCompNameDesc();
}
