package com.techwithprince.stock.dbservices.resource;

import com.techwithprince.stock.dbservices.model.Quote;
import com.techwithprince.stock.dbservices.model.Quotes;
import com.techwithprince.stock.dbservices.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;
    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }
    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username){

        return getQuotesByUsername(username);


    }

    private List<String> getQuotesByUsername(@PathVariable("username") String username) {
        return quotesRepository.findByUsername(username).stream().map(Quote::getQuote).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes){

        quotes.getQuotes().stream().map(quote -> new Quote(quotes.getUserName(),quote)).forEach(quote -> quotesRepository.save(quote));
        return getQuotesByUsername(quotes.getUserName());
    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username){

        List<Quote> quotes = quotesRepository.findByUsername(username);
        quotesRepository.deleteAll(quotes);
        return getQuotesByUsername(username);

    }
}
