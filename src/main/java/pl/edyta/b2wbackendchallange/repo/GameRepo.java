package pl.edyta.b2wbackendchallange.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.edyta.b2wbackendchallange.entity.Game;

@Repository
public interface GameRepo extends MongoRepository<Game, Integer> {
}
