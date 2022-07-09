package sardana.tinyUrl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sardana.tinyUrl.database.DatabaseService;

import java.util.Optional;

@Component
public class TinyServiceImpl implements TinyService {

  @Autowired
  private DatabaseService databaseService;

  @Override
  public boolean storeTinyUrl(String shortUrl, String longUrl) {

    if (!databaseService.fetchLongUrl(shortUrl).isPresent()) {
        databaseService.storeLongUrl(shortUrl, longUrl);
        return true;
    }
    return false;
  }

  @Override
  public Optional<String> fetchLongUrl(String shortUrl) {
    return databaseService.fetchLongUrl(shortUrl);
  }
}
