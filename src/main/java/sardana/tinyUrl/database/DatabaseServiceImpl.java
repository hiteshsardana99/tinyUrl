package sardana.tinyUrl.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sardana.tinyUrl.entity.UrlData;
import sardana.tinyUrl.repository.DatabaseRepository;

import java.util.Optional;

@Component
public class DatabaseServiceImpl implements DatabaseService {

  @Autowired
  private DatabaseRepository databaseRepository;

  @Override
  public Optional<String> fetchLongUrl(String shortUrl) {
      UrlData urlData = databaseRepository.findByShortUrl(shortUrl);

      if (urlData != null) {
        return Optional.ofNullable(urlData.getLongUrl());
      }
      return Optional.empty();
  }

  @Override
  public void storeLongUrl(String shortUrl, String longUrl) {
    databaseRepository.save(new UrlData(shortUrl, longUrl));
  }
}
