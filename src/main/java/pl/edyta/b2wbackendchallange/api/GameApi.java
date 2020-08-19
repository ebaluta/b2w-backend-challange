package pl.edyta.b2wbackendchallange.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edyta.b2wbackendchallange.entity.Game;
import pl.edyta.b2wbackendchallange.helper.DateConverter;
import pl.edyta.b2wbackendchallange.repo.GameRepo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/challange-backend")
public class GameApi {

    @Autowired
    GameRepo gameRepo;

    @GetMapping("/items")
    public List<Game> getAllItems() {
        List<Game> all = gameRepo.findAll();
        return all;
    }

    @GetMapping("/item")
    public List<Game> getSpecificItems(
            @Param("begindate") String begindate,
            @Param("finaldate") String finaldate
    ) {
        Date beginDate = DateConverter.retireveDateFromParam(begindate);
        Date finalDate = DateConverter.retireveDateFromParam(finaldate);


        List<Game> all = gameRepo.findAll();
        List<Game> filteredOut = all.stream().filter(game -> game.getDate().after(beginDate) && game.getDate().before(finalDate)).collect(Collectors.toList());
        return filteredOut;
    }
}
