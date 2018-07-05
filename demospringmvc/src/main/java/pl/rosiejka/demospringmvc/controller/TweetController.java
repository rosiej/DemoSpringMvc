package pl.rosiejka.demospringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TweetController {

    @Autowired
    private Twitter twitter;

    @RequestMapping("/")
    public String helloWorld(@RequestParam(defaultValue = "Tajniki Spring MVC4") String search, Model model){

        SearchResults searchResults = twitter.searchOperations().search(search);

        List <Tweet> tweets = searchResults.getTweets();

        model.addAttribute("tweets",tweets);
        model.addAttribute("search",search);

        return "resultPage";
    }
}
