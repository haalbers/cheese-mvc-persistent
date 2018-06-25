package org.launchcode.models.data;
import org.launchcode.models.Menu;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface MenuDao extends org.springframework.data.repository.CrudRepository<Menu, Integer> {
}
