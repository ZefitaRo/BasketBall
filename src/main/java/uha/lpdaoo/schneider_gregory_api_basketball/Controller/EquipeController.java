package uha.lpdaoo.schneider_gregory_api_basketball.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uha.lpdaoo.schneider_gregory_api_basketball.DAO.EquipeDAO;
import uha.lpdaoo.schneider_gregory_api_basketball.DAO.JoueurDAO;
import uha.lpdaoo.schneider_gregory_api_basketball.Model.Equipe;
import uha.lpdaoo.schneider_gregory_api_basketball.Model.Joueur;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController
{
    private final JoueurDAO joueurDAO;
    private EquipeDAO equipeDAO;

    public EquipeController(EquipeDAO equipeDAO, JoueurDAO joueurDAO)
    {
        this.equipeDAO = equipeDAO;
        this.joueurDAO = joueurDAO;

        equipeDAO.save(new Equipe("Chicago Bulls", "Chicago"));
        equipeDAO.save(new Equipe("Los Angeles Lakers", "Loas Angeles"));

    }

    @GetMapping
    public List<Equipe> getEquipes()
    {
        return equipeDAO.findAll();
    }

    @PostMapping
    public Equipe addNewEquipe(@RequestBody Equipe e)
    {
        return equipeDAO.save(e);
    }

}
