package sprboot.controller;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sprboot.model.Album;
import sprboot.model.Artist;
import sprboot.service.AlbumService;
import sprboot.service.ArtistService;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap modelMap) {
        ModelAndView model = new ModelAndView("album_list");
        List<Album> albumList = service.findAll();
        for (Album album : albumList) {
            album.setArtistName(artistService.getById(album.getArtistId()).getArtistName());
        }
        model.addObject("albumList", albumList);
        return model;
    }

    @RequestMapping(value = "/addAlbum/", method = RequestMethod.GET)
    public ModelAndView addAlbum() {
        ModelAndView model = new ModelAndView("album_form");
        Album album = new Album();
        List<Artist> artistList = artistService.findAll();
        model.addObject("artistList", artistList);
        model.addObject("albumForm", album);

        return model;
    }

    @RequestMapping(value = "/updateAlbum/{id}", method = RequestMethod.GET)
    public ModelAndView editAlbum(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Album album = service.getById(id);
        model.addObject("albumForm", album);
        model.setViewName("album_form");

        return model;
    }

    @RequestMapping(value = "/saveAlbum/", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("albumForm") Album album,
                             @RequestParam("artistId") String artistId) {
        album.setArtistId(Integer.parseInt(artistId));
        if (album.getAlbumName().equals("") || album.getAlbumYear() == 0 || album.getArtistId() == -1) {
            return new ModelAndView("fail_create");
        } else {
            try {
                service.save(album);
            } catch (Exception e) {
                return new ModelAndView("not_unique");
            }
            return new ModelAndView("redirect:/album/list");
        }
    }

    @RequestMapping(value = "/deleteAlbum/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        service.delete(id);

        return new ModelAndView("redirect:/album/list");
    }

    @RequestMapping(value = "/search/", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("searchInput") String search,
                               @RequestParam("field") String field) {
        ModelAndView model = new ModelAndView("album_list");
        List<Album> albumList;
        if (field.equals("-1")) {
            albumList = service.findAllByAlbumName(search);
        } else {
            albumList = service.findAllByAlbumYear(Integer.parseInt(search));
        }
        model.addObject("albumList", albumList);
        return model;
    }

    @RequestMapping(value = "/sort/", method = RequestMethod.POST)
    public ModelAndView sort(@RequestParam("direction") String direction,
                             @RequestParam("field") String field) {
        ModelAndView model = new ModelAndView("album_list");
        List<Album> albumList;
        if (direction.equals("-1")) {
            if (field.equals("-1")) {
                albumList = service.findAllByOrderByAlbumNameAsc();
            } else {
                albumList = service.findAllByOrderByAlbumYearAsc();
            }
        } else {
            if (field.equals("-1")) {
                albumList = service.findAllByOrderByAlbumNameDesc();
            } else {
                albumList = service.findAllByOrderByAlbumYearDesc();
            }
        }
        model.addObject("albumList", albumList);

        return model;
    }
}
