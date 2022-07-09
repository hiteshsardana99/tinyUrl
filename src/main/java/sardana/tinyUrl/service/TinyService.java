package sardana.tinyUrl.service;

import java.util.Optional;

public interface TinyService {

  boolean storeTinyUrl(String shortUrl, String longUrl);

  Optional<String> fetchLongUrl(String shortUrl);

}
