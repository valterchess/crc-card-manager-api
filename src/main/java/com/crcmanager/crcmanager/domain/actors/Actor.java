package com.crcmanager.crcmanager.domain.actors;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import static com.crcmanager.crcmanager.domain.enums.ActorEnum.*;

import com.crcmanager.crcmanager.domain.dtos.CardDto;
import com.crcmanager.crcmanager.domain.models.Card;
import com.crcmanager.crcmanager.domain.repositories.CardRepository;
import com.crcmanager.crcmanager.domain.repositories.ColaboracaoRepository;
import com.crcmanager.crcmanager.domain.repositories.ResponsabilidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class Actor extends AbstractBehavior<Actor.Command> {

    public interface Command{}

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ColaboracaoRepository colaboracaoRepository;
    @Autowired
    private ResponsabilidadeRepository responsabilidadeRepository;

    public static Behavior<Command> create(){
        return Behaviors.setup(Actor::new);
    }


    private Actor(ActorContext<Command> context) {
        super(context);
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals(CARD, this::getCard)
                .onMessageEquals(COLAB, this::getColab)
                .onMessageEquals(RESPONSA, this::getResponsa)
                .onMessage(CardDto.class, this::onNewCard)
                .build();
    }

    private Behavior<Command> getCard() {
        return this;
    }

    private Behavior<Command> getColab() {
        return this;
    }

    private Behavior<Command> getResponsa() {
        return this;
    }

    private Behavior<Command> onNewCard(CardDto cardDto) {
        var card = new Card();
        BeanUtils.copyProperties(cardDto, card);
        cardRepository.save(card);
        return this;
    }
}
