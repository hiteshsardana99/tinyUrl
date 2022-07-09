package sardana.tinyUrl.database;

import java.util.Optional;

public interface DatabaseService {

  Optional<String> fetchLongUrl(String shortUrl);

  void storeLongUrl(String shortUrl, String longUrl);

}
