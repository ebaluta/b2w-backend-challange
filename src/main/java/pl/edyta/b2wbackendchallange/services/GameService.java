package pl.edyta.b2wbackendchallange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edyta.b2wbackendchallange.entity.Dimension;
import pl.edyta.b2wbackendchallange.entity.Game;
import pl.edyta.b2wbackendchallange.helper.DateConverter;
import pl.edyta.b2wbackendchallange.model.payload.response.GameResponse;
import pl.edyta.b2wbackendchallange.repo.GameRepo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepo gameRepo;

    private List<GameResponse> getGames() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        GameResponse[] body = restTemplate.exchange(
                "http://www.mocky.io/v2/5817803a1000007d01cc7fc9",
                HttpMethod.GET,
                httpEntity,
                GameResponse[].class
        ).getBody();

        List<GameResponse> responses = Arrays.asList(body);
        return responses;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void saveGames() {
        List<GameResponse> games = getGames();

        if (gameRepo.count() == 0) {

            games.forEach(item -> {
                Date date = DateConverter.retrieveDateFromGameResponse(item.getDate());
                gameRepo.save(new Game(
                        item.getName(),
                        item.getCode(),
                        date,
                        new Dimension(
                                item.getDimensionResponse().getWeight(),
                                item.getDimensionResponse().getHeight(),
                                item.getDimensionResponse().getWidth(),
                                item.getDimensionResponse().getLength()
                        )
                ));
            });

        }
    }


}
