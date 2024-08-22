package com.br.matt.pweb_monitoria;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CatService {

  private final String catKey = System.getenv("CAT_API_KEY");

  private final RestTemplate restTemplate;

  public List<CatImage> getSingleCatImage() {
    String catUrl = "https://api.thecatapi.com/v1/images/search?api_key=" + catKey;

    ResponseEntity<List<CatImage>> response = restTemplate.exchange(catUrl, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<CatImage>>() {});

    return response.getBody();
  }

  public List<CatImage> getCatImages(int limit, int page, String order, int hasBreeds,
      String breedIds, String categoryIds, String subId) {
    String catUrl = "https://api.thecatapi.com/v1/images/search?api_key=" + catKey +
        "&limit=" + limit +
        "&page=" + page +
        "&order=" + order +
        "&hasBreeds=" + hasBreeds;

    if (breedIds != null) {
      catUrl += "&breedIds=" + breedIds;
    }
    if (categoryIds != null) {
      catUrl += "&categoryIds=" + categoryIds;
    }
    if (subId != null) {
      catUrl += "&subId=" + subId;
    }

    ResponseEntity<List<CatImage>> response = restTemplate.exchange(catUrl, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<CatImage>>() {});

    return response.getBody();
  }

}
