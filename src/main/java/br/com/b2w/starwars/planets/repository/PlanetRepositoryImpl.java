package br.com.b2w.starwars.planets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.b2w.starwars.planets.model.PlanetEntity;

public class PlanetRepositoryImpl implements PlanetCustomRepository{
	
	@Autowired
    private MongoTemplate mongoTemplate;
    private Collation collation;

    @Override
    public PlanetEntity findOneByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        query.collation(this.collation);

        return mongoTemplate.findOne(query, PlanetEntity.class);
    }

    @Override
    public PlanetEntity findOne(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        query.collation(this.collation);

        return mongoTemplate.findOne(query, PlanetEntity.class);
    }

}
