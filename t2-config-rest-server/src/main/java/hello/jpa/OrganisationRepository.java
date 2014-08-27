package hello.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//public interface CustomerRepository extends CrudRepository<Customer, Long> {
@RepositoryRestResource(collectionResourceRel = "organisations", path = "organisations")
public interface OrganisationRepository extends PagingAndSortingRepository<Organisation, Long> {

    List<Organisation> findByName(@Param("name") String name);
}
