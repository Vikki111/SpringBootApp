package sprboot.model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comp_name")
    private String compName;
    @Column(name = "album_id")
    private int albumId;

    @Transient
    private String albumName;

    public Composition() {
    }

    public Composition(int id, String compName, int albumId) {
        this.id = id;
        this.compName = compName;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
