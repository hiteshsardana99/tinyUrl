package sardana.tinyUrl.controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sardana.tinyUrl.service.TinyService;


@RestController
public class ServiceController {

  private static final String FALL_BACK_URL = "http://localhost:9090/NoPageFound";

  @Autowired
  private TinyService tinyService;


  @GetMapping(value = "/tiny/{shortUrl}")
  public RedirectView redirectToMainPage(@NotNull @PathVariable String shortUrl) {
    RedirectView redirectView = new RedirectView();

    redirectView.setUrl(tinyService.fetchLongUrl(shortUrl).orElse(FALL_BACK_URL));

    return redirectView;
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping(value = "/api/createShortUrl")
  public ResponseEntity<String> createUrl(@RequestParam("shortUrl") String shortUrl,
                                          @RequestParam("longUrl") String longUrl) {
    boolean isCreated = tinyService.storeTinyUrl(shortUrl, longUrl);

    if (isCreated) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

}
