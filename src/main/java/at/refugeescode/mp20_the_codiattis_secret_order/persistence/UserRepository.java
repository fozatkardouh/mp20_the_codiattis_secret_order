package at.refugeescode.mp20_the_codiattis_secret_order.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findOneByUsername(String username);

}
