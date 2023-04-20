package uha.lpdaoo.schneider_gregory_api_basketball.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uha.lpdaoo.schneider_gregory_api_basketball.Model.Joueur;

import java.util.List;

@Repository
public interface JoueurDAO extends JpaRepository <Joueur, Integer>
{
    Joueur findById(int id);

    List<Joueur> findByNom(String nom);

}
