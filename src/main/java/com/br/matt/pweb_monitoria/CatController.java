package com.br.matt.pweb_monitoria;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

  private final CatService catService;

  @GetMapping("/image")
  public ResponseEntity<List<CatImage>> getCatImage() {
    List<CatImage> image = catService.getSingleCatImage();
    return ResponseEntity.ok(image);
  }

  @GetMapping("/images")
  public ResponseEntity<List<CatImage>> getCatImages(
      @RequestParam(defaultValue = "1") int limit,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "RAND") String order,
      @RequestParam(defaultValue = "0") int hasBreeds,
      @RequestParam(required = false) String breedIds,
      @RequestParam(required = false) String categoryIds,
      @RequestParam(required = false) String subId
  ) {
    List<CatImage> images = catService.getCatImages(limit, page, order, hasBreeds, breedIds,
        categoryIds, subId);
    return ResponseEntity.ok(images);
  }

}
