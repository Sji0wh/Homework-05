package org.example;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class BlackJack {
    public static void main(String[] args) {

        //Get deck
        Response response = given()
                .header("content-type", "application/json")
                .get("https://www.deckofcardsapi.com/api/deck/new/")
                .then()
                .extract()
                .response();

        //Deserialization
        DeckDto receivedResponse = new Gson().fromJson(response.asString(),DeckDto.class);

        //Receiving deck ID
        String deckId = receivedResponse.getDeck_id();

        //Create Url for card shuffle
        String shuffleCardsUrl = "https://www.deckofcardsapi.com/api/deck/" + deckId + "/shuffle/";

        //Shuffle cards
        given()
                .header("content-type", "application/json")
                .get(shuffleCardsUrl)
                .then()
                .log()
                .all();

        //Create URL with Deck ID
        String urlForCards = "https://www.deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=6";

        //Draw card
        Response responseCards = given()
                .header("content-type", "application/json")
                .get(urlForCards)
                .then()
                .log()
                .all()
                .extract()
                .response();

        // Parse the Json response using JsonPath
        JsonPath jsonPath = JsonPath.from(responseCards.asString());

        // Extract the ArrayList of "value"
        ArrayList<String> valuesList = jsonPath.get("cards.value");

        // Convert ArrayList to String[]
        String[] values = valuesList.toArray(new String[0]);

        // Use CardValueMapper to get values for each card
        for (String cardRank : values) {
            int cardValue = CardValueMapper.getCardValue(cardRank);
            System.out.println("Card: " + cardRank + ", Value: " + cardValue);
        }

    }
}