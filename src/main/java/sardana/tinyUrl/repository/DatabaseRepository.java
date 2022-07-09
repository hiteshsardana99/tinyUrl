package sardana.tinyUrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sardana.tinyUrl.entity.UrlData;

public interface DatabaseRepository extends JpaRepository<UrlData, String> {

  UrlData findByShortUrl(String shortUrl);

}
