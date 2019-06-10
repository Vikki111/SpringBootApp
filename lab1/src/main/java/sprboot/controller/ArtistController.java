package sprboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sprboot.model.Artist;
import sprboot.service.ArtistService;

import java.util.List;

@Controller
@RequestMapping(value = "/artist")
public class ArtistController {

    @Autowired
    private ArtistService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("artist_list");
        List<Artist> artistList = service.findAll();
        model.addObject("artistList", artistList);

        return model;
    }

    @RequestMapping(value = "/addArtist/", method = RequestMethod.GET)
    public ModelAndView addArtist() {
        ModelAndView model = new ModelAndView();
        Artist artist = new Artist();
        model.addObject("artistForm", artist);
        model.setViewName("artist_form");

        return model;
    }

    @RequestMapping(value = "/updateArtist/{id}", method = RequestMethod.GET)
    public ModelAndView editArtist(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Artist artist = service.getById(id);
        model.addObject("artistForm", artist);
        model.setViewName("artist_form");

        return model;
    }

    @RequestMapping(value = "/saveArtist/", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("artistForm") Artist artist) {
        if (artist.getArtistName().equals("")) {
            ModelAndView model = new ModelAndView("fail_create");
            return model;
        } else {
            try {
                service.save(artist);
            } catch (Exception e) {
                return new ModelAndView("not_unique");
            }
            return new ModelAndView("redirect:/artist/list");
        }
    }

    @RequestMapping(value = "/deleteArtist/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        service.delete(id);

        return new ModelAndView("redirect:/artist/list");
    }

    @RequestMapping(value = "/search/", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("searchInput") String search) {
        ModelAndView model = new ModelAndView("artist_list");
        List<Artist> artistList = service.findAllByArtistName(search);
        model.addObject("artistList", artistList);

        return model;
    }

    @RequestMapping(value = "/sort/", method = RequestMethod.POST)
    public ModelAndView sort(@RequestParam("direction") String direction) {
        ModelAndView model = new ModelAndView("artist_list");
        List<Artist> artistList;
        if (direction.equals("-1")) {
            artistList = service.findAllByOrderByArtistNameAsc();
        } else {
            artistList = service.findAllByOrderByArtistNameDesc();
        }
        model.addObject("artistList", artistList);

        return model;
    }
}
