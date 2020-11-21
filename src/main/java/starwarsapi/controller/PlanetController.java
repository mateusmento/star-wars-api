package starwarsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import starwarsapi.filter.PlanetFilter;
import starwarsapi.model.Planet;
import starwarsapi.service.PlanetServiceImpl;

@CrossOrigin
@RequestMapping("planets")
@RestController
public class PlanetController {

    @Autowired
    private PlanetServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Planet> list(PlanetFilter filter) {
        return service.list(filter);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Planet findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Planet create(@RequestBody Planet planet) {
        return service.create(planet);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
