package edu.kilabs.trv.rest;

import edu.kilabs.trv.model.db.Build;
import edu.kilabs.trv.repository.BuildRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rest")
public class BuildRestController {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private BuildRepo buildRepo;

    // -----------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/builds", method = RequestMethod.GET)
    public List<Build> getAllBuilds() {
        return buildRepo.findAll();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/build/{$buildname}", method = RequestMethod.DELETE)
    public void deleteBuildByName(@PathVariable("$buildname") String buildName) {
        Optional<Build> build = buildRepo.findByName(buildName);
        build.ifPresent(b -> buildRepo.deleteById(b.getId()));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
