package ru.ttv.newsportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.service.AdvService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/adv/")
public class AdvRestController {

    @Autowired
    AdvService advService;

    @GetMapping(value = "getall", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Adv>> getAdvList() {
        List<Adv> advList = advService.getAll();
        if (advList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(advList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Adv> getAdvById(@PathVariable("id") Long advId){
        Optional<Adv> adv = advService.get(advId);
        if (adv.isPresent()){
            return new ResponseEntity<>(adv.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Adv> saveAdv(@RequestBody @Valid Adv adv){
        HttpHeaders headers = new HttpHeaders();
        if(adv==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        advService.save(adv);
        return new ResponseEntity<>(adv,headers,HttpStatus.CREATED);
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Adv> updateAdv(@RequestBody @Valid Adv adv, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();
        if(adv==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        advService.save(adv);

        return new ResponseEntity<>(adv,headers,HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Adv> deleteAdv(@PathVariable("id") Long id){
        Optional<Adv> optionalAdv = advService.get(id);
        Adv adv = optionalAdv.get();
        if(adv == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        advService.delete(adv);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

