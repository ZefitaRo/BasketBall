package uha.lpdaoo.schneider_gregory_api_basketball.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uha.lpdaoo.schneider_gregory_api_basketball.DAO.EquipeDAO;
import uha.lpdaoo.schneider_gregory_api_basketball.DAO.JoueurDAO;
import uha.lpdaoo.schneider_gregory_api_basketball.Model.Equipe;
import uha.lpdaoo.schneider_gregory_api_basketball.Model.Joueur;

import java.util.List;

@RestController
@RequestMapping("/joueur")
public class JoueurController
{
    private JoueurDAO joueurDAO;
    private final EquipeDAO equipeDAO;

    public JoueurController(JoueurDAO joueurDAO,
                            EquipeDAO equipeDAO)
    {
        this.joueurDAO = joueurDAO;

        this.joueurDAO.save(new Joueur("Jordan", 30, "Ailier Fort", 23));
        this.joueurDAO.save(new Joueur("Bryant", 25, "Ailier Fort", 24));

        this.equipeDAO = equipeDAO;
    }

    @GetMapping
    public List<Joueur> getJoueurs()
    {
        return joueurDAO.findAll();
    }

    @PostMapping
    public Joueur addNewJoueur(@RequestBody Joueur j)
    {
        return joueurDAO.save(j);
    }

    @PostMapping("/addJoueur/{id}")
    public ResponseEntity<Joueur> addEquipeToJoueur(@PathVariable int id, @RequestBody Equipe eDuPost)
    {
        Joueur joueurAquiOnAjouteEquipe = joueurDAO.findById(id);
        if (joueurAquiOnAjouteEquipe == null)
            return ResponseEntity.notFound().build();

        Equipe equipeEnBDD = equipeDAO.findByNom(eDuPost.getNom());
        if (equipeEnBDD == null)
        {
            equipeEnBDD = equipeDAO.save(eDuPost);
        }
        if (joueurAquiOnAjouteEquipe.getEquipes().contains(equipeEnBDD))
            return ResponseEntity.ok(joueurAquiOnAjouteEquipe);

        joueurAquiOnAjouteEquipe.addEquipe(equipeEnBDD);
        Joueur joueurMaj = joueurDAO.save(joueurAquiOnAjouteEquipe);
        return ResponseEntity.ok(joueurMaj);
    }

}
