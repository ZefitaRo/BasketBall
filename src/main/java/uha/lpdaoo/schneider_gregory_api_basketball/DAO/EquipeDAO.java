package uha.lpdaoo.schneider_gregory_api_basketball.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import uha.lpdaoo.schneider_gregory_api_basketball.Model.Equipe;

public interface EquipeDAO extends JpaRepository<Equipe, Integer>
{
    Equipe findByNom(String nom);
}
