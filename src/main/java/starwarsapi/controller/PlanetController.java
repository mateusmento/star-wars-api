package starwarsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import starwarsapi.model.Planet;
import starwarsapi.repository.PlanetRepository;

@CrossOrigin
@RequestMapping("planets")
@RestController
public class PlanetController {

    @Autowired
    private PlanetRepository repo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Planet> list() {
        return repo.findAll();
    }

}
