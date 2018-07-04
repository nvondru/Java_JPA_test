/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas Vondru
 */
@Entity
@Table(name = "players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p")
    , @NamedQuery(name = "Players.findById", query = "SELECT p FROM Players p WHERE p.id = :id")
    , @NamedQuery(name = "Players.findByGameTag", query = "SELECT p FROM Players p WHERE p.gameTag = :gameTag")
    , @NamedQuery(name = "Players.findByName", query = "SELECT p FROM Players p WHERE p.name = :name")
    , @NamedQuery(name = "Players.findByPrename", query = "SELECT p FROM Players p WHERE p.prename = :prename")
    , @NamedQuery(name = "Players.findByPosition", query = "SELECT p FROM Players p WHERE p.position = :position")})
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "gameTag")
    private String gameTag;
    @Column(name = "name")
    private String name;
    @Column(name = "prename")
    private String prename;
    @Column(name = "position")
    private String position;

    public Players() {
    }

    public Players(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameTag() {
        return gameTag;
    }

    public void setGameTag(String gameTag) {
        this.gameTag = gameTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Players[ id=" + id + " ]";
    }
    
}
