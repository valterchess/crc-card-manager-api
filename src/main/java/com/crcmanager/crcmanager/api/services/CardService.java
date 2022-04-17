package com.crcmanager.crcmanager.api.services;

import akka.actor.typed.ActorSystem;
import com.crcmanager.crcmanager.domain.actors.Actor;
import com.crcmanager.crcmanager.domain.dtos.CardDto;
import com.crcmanager.crcmanager.domain.models.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    ActorSystem<Actor.Command> mySystem = ActorSystem.create(Actor.create(), "mySystem");

    public ResponseEntity<Card> newCard(CardDto cardDto){
        return null;
    }
}
