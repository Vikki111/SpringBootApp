package sprboot.model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="artist")
public class Artist {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "artist_name")
    private String artistName;

    public Artist() {
    }

    public Artist(int id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
