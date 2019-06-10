package sprboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sprboot.model.Album;
import sprboot.model.Composition;
import sprboot.service.AlbumService;
import sprboot.service.CompositionService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/composition")
public class CompositionController {

    @Autowired
    private CompositionService service;

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("composition_list");
        List<Composition> compositionList = service.findAll();
        for (Composition composition : compositionList) {
            composition.setAlbumName(albumService.getById(composition.getAlbumId()).getAlbumName());
        }
        model.addObject("compositionList", compositionList);

        return model;
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public ModelAndView album(@PathVariable int id) {
        ModelAndView model = new ModelAndView("album");
        Album album = albumService.getById(id);
        model.addObject("album", album);
        return model;
    }

    @RequestMapping(value = "/addComposition/", method = RequestMethod.GET)
    public ModelAndView addComposition() {
        ModelAndView model = new ModelAndView("composition_form");
        Composition composition = new Composition();
        List<Album> albumList = albumService.findAll();
        model.addObject("albumList", albumList);
        model.addObject("compositionForm", composition);

        return model;
    }

    @RequestMapping(value = "/updateComposition/{id}", method = RequestMethod.GET)
    public ModelAndView editComposition(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Composition composition = service.getById(id);
        model.addObject("compositionForm", composition);
        model.setViewName("composition_form");

        return model;
    }

    @RequestMapping(value = "/saveComposition/", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("compositionForm") Composition composition,
                             @RequestParam("albumId") String albumId) {
        composition.setAlbumId(Integer.parseInt(albumId));
        if (composition.getCompName().equals("") || composition.getAlbumId() == -1) {
            ModelAndView model = new ModelAndView("fail_create");
            return model;
        } else {
            service.save(composition);
            return new ModelAndView("redirect:/composition/list");
        }
    }

    @RequestMapping(value = "/deleteComposition/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        service.delete(id);

        return new ModelAndView("redirect:/composition/list");
    }

    @RequestMapping(value = "/search/", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("searchInput") String search) {
        ModelAndView model = new ModelAndView("composition_list");
        List<Composition> compositionList;
        compositionList = service.findAllByCompName(search);
        model.addObject("compositionList", compositionList);
        return model;
    }

    @RequestMapping(value = "/sort/", method = RequestMethod.POST)
    public ModelAndView sort(@RequestParam("direction") String direction,
                             @RequestParam("field") String field) {
        ModelAndView model = new ModelAndView("composition_list");
        List<Composition> compositionList;
        if (direction.equals("-1")) {
            compositionList = service.findAllByOrderByCompNameAsc();
        } else {
            compositionList = service.findAllByOrderByCompNameDesc();
        }
        model.addObject("compositionList", compositionList);

        return model;
    }
}
