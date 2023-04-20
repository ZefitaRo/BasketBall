package uha.lpdaoo.schneider_gregory_api_basketball.Model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipe
{
    @Id
    @GeneratedValue
    private int id;

    private String nom;

    @Column(nullable = false, unique = true)
    private String ville;

    @OneToMany(cascade = { CascadeType.PERSIST})
    List<Joueur> joueurs = new ArrayList<>();

    public List<Joueur> getJoueurs()
    {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs)
    {
        this.joueurs = joueurs;
    }

    public void AddJoueur(Joueur joueur)
    {
        this.joueurs.add(joueur);
    }

    public Equipe(String nom, String ville)
    {
        this.nom = nom;
        this.ville = ville;
    }

    public Equipe()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }



}
