package sprboot.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name="album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "album_name")
    private String albumName;
    @Column(name = "album_year")
    private int albumYear;
    @Column(name = "artist_id")
    private int artistId;

    @Transient
    private String artistName;

    public Album() {
    }

    public Album(int id, String albumName, int albumYear, int artistId) {
        this.id = id;
        this.albumName = albumName;
        this.albumYear = albumYear;
        this.artistId = artistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
