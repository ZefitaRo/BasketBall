package uha.lpdaoo.schneider_gregory_api_basketball.Model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Joueur
{


    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private int age;

    private String position;

    private int num;

    @OneToMany(cascade = { CascadeType.PERSIST})
    List<Equipe> equipes = new ArrayList<>();

    public List<Equipe> getEquipes()
    {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes)
    {
        this.equipes = equipes;
    }

    public void addEquipe(Equipe equipe)
    {
        this.equipes.add(equipe);
    }

    public Joueur(String nom, int age, String position, int num)
    {
        this.nom = nom;
        this.age = age;
        this.position = position;
        this.num = num;
    }

    public Joueur()
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



}
